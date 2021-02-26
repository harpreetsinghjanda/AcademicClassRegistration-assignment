package com.my.AcademicClassRegistration.professor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.AcademicClassRegistration.professor.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer>  {

	
}
