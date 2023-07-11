package org.example.model;

import org.springframework.stereotype.Component;

@Component
public class Location {
	private int locationId;
	private String locationName;
	private String country;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", country=" + country + "]";
	}
}
