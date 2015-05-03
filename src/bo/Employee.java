package bo;

public class Employee {

	private long employeeId;
	private String name;
	private String street;
	private City city;
	private Company company;

	public Employee() {

	}

	public Employee(String name, String street) {
		this.setName(name);
		this.setStreet(street);
	}
	public Employee(String name, String street, Company company, City city) {
		this.setName(name);
		this.setStreet(street);
		this.setCompany(company);
		this.setCity(city);
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}


}
