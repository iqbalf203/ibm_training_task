package project5;

public class Employee {
		
		private String employeeName;
		private String employeeId;
		private int employeeSalary;
		private Department department;
	
		public Employee() {

		}

		// local variables
		public Employee(String employeeName, String employeeId, int employeeSalary, Department department) {

			this.employeeName = employeeName;
			this.employeeId = employeeId;
			this.employeeSalary = employeeSalary;
			this.department = department;
		}
	// default constructor	

		public String getEmployeeName() {
			return employeeName;
		}

		public void setEmployeeName(String employeeName) {
			this.employeeName = employeeName;
		}

		public String getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(String employeeId) {
			this.employeeId = employeeId;
		}

		public int getEmployeeSalary() {
			return employeeSalary;
		}

		public void setEmployeeSalary(int employeeSalary) {
			this.employeeSalary = employeeSalary;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		@Override
		public String toString() {
			return "=================================\nemployeeName=" + employeeName + ", employeeId=" + employeeId + ", employeeSalary="
					+ employeeSalary + "\n=========================\ndepartment=" + department + "\n";
		}




}
