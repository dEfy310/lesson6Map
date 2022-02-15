package pro.sky.java.course2.lesson6map;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<String, Employee> employeeMap = new HashMap<>();

    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();
    }


    private Employee createEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employee;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        String k = (firstName + " " + lastName);
        return employeeMap.put(k, createEmployee(firstName, lastName));
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        String k = (firstName + " " + lastName);
        if (employeeMap.containsKey(k)) {
            return employeeMap.remove(k, createEmployee(firstName, lastName));
        }
        throw new NotFoundEmployeeException();
    }

    @Override
    public Employee getEmployeeByKey(String firstName, String lastName) {
        String k = (firstName + " " + lastName);
        if (employeeMap.containsKey(k)) {
            return employeeMap.get(k);
        }
        throw new NotFoundEmployeeException();
    }

    @Override
    public Set<Employee> getEmployees() {
        return new HashSet<>(employeeMap.values());
    }
}
