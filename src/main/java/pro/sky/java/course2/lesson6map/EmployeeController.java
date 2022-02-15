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

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public boolean removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find-by-key")
    public Employee findEmployeeByKey(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.getEmployeeByKey(firstName, lastName);
    }

    @GetMapping("/find-by-value")
    public Employee findEmployeeByValue(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.getEmployeeByValue(firstName, lastName);
    }

    @GetMapping
    public Set<Employee> getEmployeeList() {
        return employeeServiceImpl.getEmployeeMap();

    }
}
