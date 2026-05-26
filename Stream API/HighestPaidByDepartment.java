import models.Employee;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

public class HighestPaidByDepartment {
    public static Map<String, Optional<Employee>> highestPaidByDepartment(List<Employee> employees) {
        if (employees == null || employees.isEmpty()) return new HashMap<>();

        Map<String, Optional<Employee>> result = employees.stream()
                .filter(s -> s.getSalary() > 1000)
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))
                ));

        return result;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Sơn", "IT", 1500),
                new Employee("Tùng", "IT", 2500),
                new Employee("Hoa", "HR", 1200),
                new Employee("Linh", "HR", 800),  // Bị loại vì lương < 1000
                new Employee("Hải", "IT", 2000)
        );

        Map<String, Optional<Employee>> result = highestPaidByDepartment(employees);

        // Kết quả mong đợi: {HR=Optional[Hoa (1200)], IT=Optional[Tùng (2500)]}
        System.out.println("Nhân viên lương cao nhất theo phòng ban: " + result);
    }
}
