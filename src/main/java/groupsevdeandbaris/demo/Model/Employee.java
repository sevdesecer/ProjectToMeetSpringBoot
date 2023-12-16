package groupsevdeandbaris.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long ID;

    //@JsonProperty("full_name")

    @NotNull(message = "Name can not be null.")
    @Column(name = "Name")
    private String name;

    //@JsonIgnore

    @Column(name = "Age")
    private Long age = 0L;

    @Column(name = "Location")
    private String location;

    @Email(message = "Please enter the valid email address.")
    @Column(name = "Email")
    private String email;

    @NotNull(message = "Department can not be null.")
    @Column(name = "Department")
    private String department;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
}
