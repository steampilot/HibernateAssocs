package bo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jerome.roethlisberge on 03.05.2015.
 */
public class Company {
	private long companyId;
	private String name;
	private City city;
	private List<Employee> employees;

	public Company() {
	}

	public Company(String name, City city) {
		this.setName(name);
		this.setCity(city);
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

}
