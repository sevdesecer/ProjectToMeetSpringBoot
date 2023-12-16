package groupsevdeandbaris.demo.IEmployeeService;

import groupsevdeandbaris.demo.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> getEmployees(int pageNumber, int pageSize);

    List<Employee> getEmployees();

    Employee saveEmployee (Employee employee);

    void deleteEmployee (Long ID);
    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmpByNameAndLoc(String name, String location);
    List<Employee> getEmployeesByKeyword(String name);

    List<Employee> getEmployeeByNameOrLocation(String name, String location);

    Integer deleteEmployeesByName(String name);
}
