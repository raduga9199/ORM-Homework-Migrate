package com.cydeo.repository;

import com.cydeo.entity.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {
    // find all courses by category
    List<Course> findByCategory(String category);

    // find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //check if a course with the provided name exists. return true
    // if course exists, false otherwise
    boolean existsByName(String name);

    //returns the count of courses for the provided category
    int countByCategory(String category);

    // find all courses that starts with the provided course name
    List<Course> findByNameStartingWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);

    @Query("SELECT c from Course c where c.category = :category and c.rating >:rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category,
                                                       @Param("rating") int rating);

    @Modifying
    @Transactional
    @Query("update Employee e SET e.email ='admin@email.com' WHERE  e.id=:id")
    void updateEmployeeJPQL(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update employees SET email ='admin@email.com' WHERE  id=:id", nativeQuery = true)
    void updateEmployeeNativeQuery(@Param("id") int id);

}
