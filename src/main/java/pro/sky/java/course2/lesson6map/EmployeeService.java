package pro.sky.java.course2.lesson6map;

import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, Integer id);

    Employee removeEmployee(String firstName, String lastName, Integer id);

    Employee getEmployeeByKey(Integer id, String firstName, String lastName);

    Employee getEmployeeByValue(String firstName, String lastName);

    Set<Employee> getEmployeeMap();
}
