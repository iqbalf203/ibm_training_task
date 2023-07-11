package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Location {

	private int locationId;
	private String locationName;
	private String county;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	@Override
	public String toString() {
		return "locationId: " + locationId + " location name: " + locationName + " county: " + county;
	}
	
	
}
