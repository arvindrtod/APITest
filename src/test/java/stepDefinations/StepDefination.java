package stepDefinations;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;


import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class StepDefination extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    JsonPath js;
    public static String place_id;

    TestDataBuild data = new TestDataBuild();

    @Step("Add place payload <name> <language> <address>")
    public void add_place_payload(String name, String language, String address) throws IOException {
        res = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
    }

    @Step("user calls <string> with <string> http request")
    public void user_calls_with_http_request(String resource, String method) {
        ResponseSpecification resspec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200).build();

        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        if (method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource())
                    .then().spec(resspec).extract().response();
        else if (method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourceAPI.getResource())
                    .then().spec(resspec).extract().response();
        }

    }

    @Step("the API call got success with status code <int>")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Step("<string> in response body is <string>")
    public void in_response_body_is(String key, String value) {

        Assert.assertEquals(getJsonPath(response, key), value);
    }

    @Step("verify place_Id created maps to <name> using <getPlaceAPI>")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {

        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(actualName, expectedName);
    }


    @Step("DeletePlace Payload")
    public void delete_place_payload() throws Exception {
        System.out.println(place_id);
        if (place_id != null)
            res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
        else throw new Exception("Place Id doesnt exist");
    }

}

