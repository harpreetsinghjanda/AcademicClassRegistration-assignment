package com.my.AcademicClassRegistration.professor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.my.AcademicClassRegistration.course.model.Course;
import com.my.AcademicClassRegistration.course.service.CourseService;
import com.my.AcademicClassRegistration.professor.model.Professor;
import com.my.AcademicClassRegistration.professor.service.ProfessorService;

@RestController
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/professors")
	public List<Professor> getProfessor()	{
		return professorService.getProfessor();
	}
	
	@PostMapping("/professors")
	@ResponseStatus(code = HttpStatus.CREATED)
	public List<Professor> addProfessors( @RequestBody List<Professor> professors) {
		
		List<Professor> addedProfessors =  professorService.saveProfessors(professors);
		
		return addedProfessors;
	}
	
	@GetMapping("/professors/{professorId}")
	public Professor findProfessor( @PathVariable int professorId) {
		
		return  professorService.findProfessor(professorId);
				
	}
	
	@PatchMapping("/professors/{professorId}/courses")
	public Professor assignCoursesToPofessor( @PathVariable int professorId, @RequestBody Course course) {
		
		Course searchedCourse = courseService.findCourse(course.getCourseId());
		Professor professor = professorService.findProfessor(professorId);
		
		professor.setCourse(searchedCourse);
		
		return  professorService.saveProfessor(professor);
				
	}
	
	@GetMapping("/professors/{professorId}/courses")
	public Course getCoursesForPrfessor(@PathVariable int professorId) {
		
		Professor professor = professorService.findProfessor(professorId);
			
		return professor.getCourse();
				
	}
	
	@DeleteMapping("/professors/{professorId}")
	public void deleteProfessor(@PathVariable int professorId)	{
		
		professorService.deleteProfessor(professorId);
		
	}
	
	@DeleteMapping("/professors/{professorId}/courses")
	public Professor removeStudentFromCourse(@PathVariable int professorId) {
		
		Professor professor = professorService.findProfessor(professorId);
		
		professor.setCourse(null);
		
		return professorService.saveProfessor(professor);				
				
	}
}
