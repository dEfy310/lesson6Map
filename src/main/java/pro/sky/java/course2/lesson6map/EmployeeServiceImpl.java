package pro.sky.java.course2.lesson6map;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Integer nextId = 0;
    private Map<Integer, Employee> employeeMap = new HashMap<>();


    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();
    }

    private Integer getNextId() {
        Integer result = nextId;
        nextId += 1;
        return result;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, Integer id) {
        Employee employee = new Employee(firstName, lastName);
        employeeMap.put(getNextId(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, Integer id) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(id)) {
            employee = employeeMap.remove(id);
            return employee;
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    @Override
    public Employee getEmployeeByKey(Integer id, String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsKey(id)) {
            employee = employeeMap.get(id);
        }
        return employee;
    }

    @Override
    public Employee getEmployeeByValue(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeMap.containsValue(employee)) {
            return employee;
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    @Override
    public Set<Employee> getEmployeeMap() {
        return new HashSet<>(employeeMap.values());
    }
}
