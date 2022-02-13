package pro.sky.java.course2.lesson6map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public Employee addEmployee(@RequestParam() String firstName, @RequestParam() String lastName, @RequestParam Integer id) {
        return employeeServiceImpl.addEmployee(firstName, lastName, id);
    }

    @GetMapping(path = "/remove")
    public Employee removeEmployee(@RequestParam() String firstName, @RequestParam() String lastName, @RequestParam Integer id) {
        return employeeServiceImpl.removeEmployee(firstName, lastName, id);
    }

    @GetMapping(path = "/find-by-key")
    public Employee findEmployeeByKey(@RequestParam() Integer id, @RequestParam() String firstName, @RequestParam() String lastName) {
        return employeeServiceImpl.getEmployeeByKey(id, firstName, lastName);
    }

    @GetMapping(path = "/find-by-value")
    public Employee findEmployeeByValue(@RequestParam() String firstName, @RequestParam() String lastName) {
        return employeeServiceImpl.getEmployeeByValue(firstName, lastName);
    }

    @GetMapping
    public Set<Employee> getEmployeeList() {
        return employeeServiceImpl.getEmployeeMap();

    }
}