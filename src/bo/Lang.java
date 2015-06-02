package bo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by steampilot on 19.05.15.
 */
public class Lang {
    private long langId;
    private String iso;
    private Set<Employee> employees = new HashSet<Employee>();

    private String name;

    public Lang(long langId) {
        this.langId = langId;
    }

    public Lang(String iso, String name) {
        this.iso = iso;
        this.name = name;
    }

    public Lang() {
    }

    public long getLangId() {
        return langId;
    }

    public void setLangId(long langId) {
        this.langId = langId;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
