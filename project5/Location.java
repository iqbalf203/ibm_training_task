package project5;

public class Location {

	private String locationId;
	private String city;
	private int zipCode;
	private String countryName;

	public Location() {

	}


	
	


	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}






	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", city=" + city + ", zipCode=" + zipCode + ", countryName="
				+ countryName + "]";
	}

}
