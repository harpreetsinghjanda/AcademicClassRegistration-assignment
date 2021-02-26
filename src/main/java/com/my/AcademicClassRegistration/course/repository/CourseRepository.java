package com.my.AcademicClassRegistration.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.AcademicClassRegistration.course.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>  {

	/*private static List<Course> courseList = new ArrayList<Course>();
	static int counter = 2;
	static Integer[] i = {1,2};
	static {
		courseList.add(new Course(1, "Course 1", i));
		courseList.add(new Course(2, "Course 2", i));
	}
	
	public int[] addCourses(Course[] courses)	{
		
		int[] courseIds = new int[courses.length];
		int i=0;
		for ( Course course : courses)	{
			if( course.getCourseId() == null)	{
				course.setCourseId(++counter);
				courseList.add(course);
			}
			courseIds[i++] = course.getCourseId();
		}
		
		return courseIds;
	}
	
	
	public List<Course> getCourses() {
		return courseList;
	}
	
	public Course findCourse(Integer courseId) {
		
		for( Course course : courseList) {
			if( course.getCourseId().equals(courseId)) {
				return course;
			}
		}
		
		return null;

	}*/
	

}
