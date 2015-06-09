package bo;

import java.util.HashSet;
import java.util.Set;

public class Employee {

	private long employeeId;
	private String name;
	private String street;
	private City city;

    private Set<Lang> languages = new HashSet<Lang>();

	public Employee() {

	}

	public Employee(String name, String street) {
		this.setName(name);
		this.setStreet(street);
	}
	public Employee(String name, String street, City city) {
		this.setName(name);
		this.setStreet(street);

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





	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

    public Set<Lang> getLanguages() {
        return languages;
    }
    public void setLanguages(Set<Lang> languages){
        this.languages = languages;
    }
    public void addLanguage(Lang language){
        this.languages.add(language);
    }
}
