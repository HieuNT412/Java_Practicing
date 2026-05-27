import models.Department;
import models.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class GetHighSalaryEmployeeNames {
    public static List<String> getHighSalaryEmployeeNames(List<Department> departments) {
        if (departments == null || departments.isEmpty()) return new ArrayList<>();

        return departments.stream().flatMap(d -> d.getEmployees().stream())
                .filter(s -> s.getSalary() > 2000)
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> totalSalaryByDept(List<Department> departments) {
        if (departments == null || departments.isEmpty()) return new HashMap<>();

        Map<String, Integer> result = departments.stream().flatMap(e -> e.getEmployees().stream())
                .filter(s -> s.getSalary() > 1000)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)
                ));

        return result;
    }

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu dựa trên lớp Employee bạn đã có
        Employee son = new Employee("Sơn", "IT", 1500);
        Employee tung = new Employee("Tùng", "IT", 2500);
        Employee hoa = new Employee("Hoa", "HR", 3000);
        Employee linh = new Employee("Linh", "HR", 1800);

        Department it = new Department("IT", Arrays.asList(son, tung));
        Department hr = new Department("HR", Arrays.asList(hoa, linh));

        List<Department> departments = Arrays.asList(it, hr);

        List<String> result = getHighSalaryEmployeeNames(departments);
        Map<String, Integer> result2 = totalSalaryByDept(departments);

        // Kết quả mong đợi: [Tùng, Hoa]
        System.out.println("Nhân viên lương cao: " + result);
        System.out.println(" " + result2);
    }
}
