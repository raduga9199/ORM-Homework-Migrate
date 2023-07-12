package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //display all employees with email address
    List<Employee> findByEmail(String email);

    // display all employees with firstName '' and lastName '',
    // also show all employees with an email address not null

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName,
                                                      String lastName,
                                                      String email);

    // display all employees that firs name is not ''
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where last name starts with ''
    List<Employee> findByLastNameStartsWith(String pattern);

    //display all employees with salaries higher than ''
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //display all employees with salaries less than ''
    List<Employee> findBySalaryLessThanEqual(Integer salary);

    // display all employees that has been hired between '' and ''
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //display all employees where salaries greater and equal to '' in order
    List<Employee> findBySalaryIsGreaterThanEqualOrderBySalary(Integer salary);

    //Display Top 3 unique employees that makes less than ''
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    // display all employees that do not have emails
    List<Employee> findByEmailIsNull();

    @Query("SELECT e FROM Employee e WHERE e.email = 'sdubber7@t-online.de'")
    Employee getEmployeeDetail();

    @Query("SELECT e.salary from Employee e where e.email = 'sdubber7@t-online.de'")
    Integer getEmployeeSalary();

    @Query("SELECT e from Employee e where e.email = ?1")
    Optional<Employee> getEmployeeDetails(String email);

    @Query("SELECT e from Employee e where e.email = ?1 and e.salary = ?2")
    Employee getEmployeeDetail(String email, int salary);

    // Not Equal
    @Query("select e from Employee e where e.salary <> ?1")
    List<Employee> getEmployeeSalaryNotEqual(int salary);

    //like/contains/startswith/endswith
    @Query("select e from Employee e where e.firstName like ?1")
    List<Employee> getEmployeeFirstNameLike(String pattern);

    // less than
    @Query("select e from Employee e where e.salary < ?1")
    List<Employee> getEmployeeSalaryLessThan(int salary);

    // greater than
    @Query("select e from Employee e where e.salary > ?1")
    List<Employee> getEmployeeSalaryGreaterThan(int salary);

    // before
    @Query("select e from Employee e where e.hireDate > ?1 ")
    List<Employee> getEmployeeHiredBefore(LocalDate date);

    // between
    @Query("select e from Employee e where e.salary between ?1 and ?2")
    List<Employee> getEmployeeSalaryBetween(int salary1, int salary2);

    // Not Null
    @Query("select e from Employee e where e.email is not null")
    List<Employee> getEmployeeEmailNotNull();

    // Null
    @Query("select e from Employee e where e.email is null")
    List<Employee> getEmployeeEmailNull();

    // Sorting in ascending order
    @Query("select e from Employee e order by e.salary asc")
    List<Employee> getEmployeeSalaryInAscendingOrder();

    // Sorting in descending order
    @Query("select e from Employee e order by e.salary desc")
    List<Employee> getEmployeeSalaryInDescendingOrder();

    @Query(value = "SELECT * FROM employees where salary ?1",nativeQuery = true)
    List<Employee> readEmployeeDetailsBySalary(int salary);
}
