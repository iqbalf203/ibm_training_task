package project5;

public class Department {

	
	//departmentId
	//departmentName
	//Location location
	
	//createDepartment
	
	private String departmentId;
	private String departmentName;
	private Location location;
	
	
	
	public Department() {
		
	}
	
	





	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}







	@Override
	public String toString() {
		return "departmentId=" + departmentId + ", departmentName=" + departmentName + "\n===========================\nlocation="
				+ location + "\n";
	}
}
