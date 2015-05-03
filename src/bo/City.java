package bo;

import java.util.ArrayList;
import java.util.List;

public class City {
	private long cityId;
	private String zip;
	private String name;
	private List<Employee> employees = null;
	private List<Company> companies = null;

	public City() {

	}

	public City(String name, String zip) {
		this.setName(name);
		this.setZip(zip);
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee e) {
		if (employees == null) {
			employees = new ArrayList<Employee>();
		}
		employees.add(e);
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public void addCompany(Company company) {
		if (companies == null) {
			companies = new ArrayList<Company>();
		}
		this.companies.add(company);

	}
}
