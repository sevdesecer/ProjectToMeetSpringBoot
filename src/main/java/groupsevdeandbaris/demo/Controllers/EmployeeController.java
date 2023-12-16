package groupsevdeandbaris.demo.Controllers;

import groupsevdeandbaris.demo.IEmployeeService.EmployeeService;
import groupsevdeandbaris.demo.Model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // @Controller + @ResponseBody
//@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService eService;

   /*
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public String getAppDetails(){
        return appName + " - " + appVersion;
    }
    */

    @GetMapping("getEmployees")
    public List<Employee> getEmployeesFromService(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
        return eService.getEmployees(pageNumber,pageSize);
    }

    @GetMapping("getEmployee/{id}")
    public String getEmployee(@PathVariable("id") Long id){  //It takes "id" parameter as path variable.

        return "Fetching the employee details for the id " + id + ".";
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return eService.saveEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        System.out.println("Updating the employee data for the id " + id + ".");
        employee.setID(id);
        return eService.updateEmployee(employee);
    }

    // localhost:8080/deleteEmployees?id=21
    @DeleteMapping("/deleteEmployees")
    public void deleteEmployee(@RequestParam("id") Long id){
        eService.deleteEmployee(id);
    }

    @GetMapping("/getEmployees/filterByName")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByName(name), HttpStatus.OK);
    }

    @GetMapping("/getEmployees/filterByNameAndLoc")
    public ResponseEntity<List<Employee>> getEmpByNameAndLoc(@RequestParam String name, String location){
        return new ResponseEntity<List<Employee>>(eService.getEmpByNameAndLoc(name, location), HttpStatus.OK);
    }


    @GetMapping("/getEmployees/filterByKeyword")
    public ResponseEntity<List<Employee>> getEmployeesByKeyword(@RequestParam String name){
        return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name), HttpStatus.OK);
    }

    @GetMapping("/getEmployees/{name}/{location}")
    public ResponseEntity<List<Employee>> getEmployeesByNameOrLocation(@PathVariable String name, @PathVariable String location){
        return new ResponseEntity<List<Employee>>(eService.getEmployeeByNameOrLocation(name,location), HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/delete/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
        return new ResponseEntity<String>(eService.deleteEmployeesByName(name) + " No of record deleted.", HttpStatus.OK);
    }


}
