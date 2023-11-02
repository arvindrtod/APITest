package resources;



import com.thoughtworks.gauge.BeforeScenario;
import stepDefinations.StepDefination;


import java.io.IOException;

public class Hooks {

@BeforeScenario(tags = "DeletePlace")
public void beforeScenario() throws IOException {

	StepDefination m= new StepDefination();
	if(StepDefination.place_id==null) {
	m.add_place_payload("Shetty", "English", "Asia");
	m.user_calls_with_http_request("AddPlaceAPI","POST");
	m.verify_place_id_created_maps_to_using("Shetty","getPlaceAPI");
	}
}
}
