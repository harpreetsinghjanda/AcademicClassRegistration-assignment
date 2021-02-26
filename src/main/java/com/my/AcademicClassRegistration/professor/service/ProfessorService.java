package com.my.AcademicClassRegistration.professor.service;

import java.util.List;

import com.my.AcademicClassRegistration.professor.model.Professor;

public interface ProfessorService {

	public List<Professor> saveProfessors(List<Professor> professors);

	public Professor saveProfessor(Professor professor);
	
	public List<Professor> getProfessor();
	
	public Professor findProfessor(Integer professorId);
	
	public void deleteProfessor(Integer professorId);
}
