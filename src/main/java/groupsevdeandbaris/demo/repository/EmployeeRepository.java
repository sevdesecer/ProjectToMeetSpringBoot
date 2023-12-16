package groupsevdeandbaris.demo.repository;
import groupsevdeandbaris.demo.Model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
import static org.springframework.http.HttpHeaders.FROM;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long > {

    // SELECT * FROM table WHERE name = "sevde"
    List<Employee>findByName(String name);

    // SELECT * FROM table WHERE name= "sevde" AND location ="eskisehir"
    List<Employee>findByNameAndLocation(String name, String location);

    // SELECT * FROM table WHERE name LIKE "%ram%"
    List<Employee>findByNameContaining(String keyword, Sort sort);

    void deleteById(Long id);

    Employee save(Employee employee);

    @Query(value = "FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeesByNameOrLocation(String name, String location);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Employee WHERE name = :name")
    Integer deleteEmployeesByName(String name);

}
