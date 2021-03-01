package com.my.AcademicClassRegistration.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.AcademicClassRegistration.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>  {

}
