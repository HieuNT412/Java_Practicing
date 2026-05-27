package models;

import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees; // Danh sách nhân viên thuộc phòng này

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
    public List<Employee> getEmployees() { return employees; }
}
