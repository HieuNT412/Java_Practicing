package models;

public class Employee {
    private String name;       // Tên nhân viên
    private String department; // Phòng ban (Ví dụ: "IT", "HR")
    private int salary;        // Lương

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() { return department; }
    public int getSalary() { return salary; }
    public String getName() { return name; }

    @Override
    public String toString() { return name + " (" + salary + ")"; }
}
