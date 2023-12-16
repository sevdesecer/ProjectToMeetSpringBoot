package groupsevdeandbaris.demo.IEmployeeService;

import groupsevdeandbaris.demo.Model.Employee;
import groupsevdeandbaris.demo.repository.EmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{

    private final EmployeeRepository eRepository;

    public EmployeeService(EmployeeRepository eRepository) {
        this.eRepository = eRepository;
    }

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize){

        PageRequest pages = PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC, "ID");
        return eRepository.findAll(pages).getContent();
}

    @Override
    public List<Employee> getEmployees() {
        return null;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long ID) {
        eRepository.deleteById(ID);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return eRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return eRepository.findByName(name);
    }

    @Override
    public List<Employee> getEmpByNameAndLoc(String name, String location) {
        return eRepository.findByNameAndLocation(name,location);
    }

    @Override
    public List<Employee> getEmployeesByKeyword(String name) {

        Sort sort = Sort.by( Sort.Direction.DESC, "ID");
        return eRepository.findByNameContaining(name,sort);
    }

    @Override
    public List<Employee> getEmployeeByNameOrLocation(String name, String location) {
        return eRepository.getEmployeesByNameOrLocation(name,location);
    }

    @Override
    public Integer deleteEmployeesByName(String name) {
        return eRepository.deleteEmployeesByName(name);
    }


}
