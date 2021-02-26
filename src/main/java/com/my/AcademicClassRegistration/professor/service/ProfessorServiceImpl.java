package com.my.AcademicClassRegistration.professor.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.AcademicClassRegistration.professor.exception.ProfessorNotFoundException;
import com.my.AcademicClassRegistration.professor.model.Professor;
import com.my.AcademicClassRegistration.professor.repository.ProfessorRepository;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorRepository professorRepo;
	
	public List<Professor> saveProfessors(List<Professor> professors)	{
		return professorRepo.saveAll(professors);
	}

	public Professor saveProfessor(Professor professor)	{
		return professorRepo.save(professor);
	}
	
	public List<Professor> getProfessor() {
		return professorRepo.findAll();
	}
	
	public Professor findProfessor(Integer professorId) {
		
		Optional<Professor> professor =  professorRepo.findById(professorId);

		if( !professor.isPresent()) {
			throw new ProfessorNotFoundException("Professor Not found with ID : " +  professorId);
		}
		
		return professor.get();
		
	}
	
	public void deleteProfessor(Integer professorId) {
		
		professorRepo.deleteById(professorId);
		
	}
}

