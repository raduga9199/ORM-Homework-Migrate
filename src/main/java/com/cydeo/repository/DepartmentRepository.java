package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {
    // display all departments in the furniture
    List<Department> findByDepartment(String department);

    //display all departments in the health division
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display top 3 departments with division name includes 'HEA', without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String division);

    @Query("select d from Department d where d.division in ?1")
    List<Department> getDepartmentDivision(List<String> division);



}
