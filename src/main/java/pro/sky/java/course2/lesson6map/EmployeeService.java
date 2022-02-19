package pro.sky.java.course2.lesson6map;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee getEmployee(String firstName, String lastName);

    Set<Employee> getEmployees();
}
