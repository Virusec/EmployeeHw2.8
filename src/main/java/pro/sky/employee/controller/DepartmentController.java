package pro.sky.employee.controller;

import pro.sky.employee.data.Employee;
import pro.sky.employee.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/min-salary")
    Employee getEmployeeWithMinSalary(@RequestParam(name = "departmentId") int department) {
        return departmentService.getEmployeeWithMinSalary(department);
    }

    @GetMapping("/max-salary")
    Employee getEmployeeWithMaxSalary(@RequestParam(name = "departmentId") int department) {
        return departmentService.getEmployeeWithMaxSalary(department);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    Collection<Employee> getEmployeesFor(@RequestParam(name = "departmentId") int department) {
        return departmentService.getEmployeesFor(department);
    }

    @GetMapping("/all")
    Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployeesByDepartment();
    }
}
