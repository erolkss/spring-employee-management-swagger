package br.com.ero.employeemanagement.swagger.models;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "employee_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "Employee details.")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 195435591137869829L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ApiModelProperty(notes = "The employee first name.")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "department_name")
    private String departmentName;
    @Column(name = "phone")
    private String phone;

}
