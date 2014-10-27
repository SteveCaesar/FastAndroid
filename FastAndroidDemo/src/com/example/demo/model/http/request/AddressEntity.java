package com.example.demo.model.http.request;

import com.fastandroid.lib.json.JsonField;


public class AddressEntity {
	@JsonField(name = "location")
	public String location;
	@JsonField(name = "address")
	public String address;
	@JsonField(name = "type")
	public String type;
	@JsonField(name = "username")
	public String username;
	@JsonField(name = "id")
	public String id;
	@JsonField(name = "creationDate")
	public String creationDate;

}
