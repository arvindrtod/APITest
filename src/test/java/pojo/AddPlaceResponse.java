package pojo;

public class AddPlaceResponse {
	private String status;
	private String place_id;
	private String scope;
	private String reference;
	private String id;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlace_id() {
		return place_id;
	}
	public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}

//{
//"status": "OK",
//"place_id": "1bd41a3304725d48e1d320d8caa494d9",
//"scope": "APP",
//"reference": "bc11c24485128f54e6aa3f250f17e88dbc11c24485128f54e6aa3f250f17e88d",
//"id": "bc11c24485128f54e6aa3f250f17e88d"
//}