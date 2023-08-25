package co.edu.ue.controller;


import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.model.Course;


@RestController
public class CourseController {
	
	Course course;
	
	// CREAMOS CONSTRUCTOR DE CURSO
	@PostConstruct
	public void init() {
		course = new Course();
	}
	
	
	// TRAEMOS LA LISTA QUE TIENE CURSOS EN COURSE
	@GetMapping(value="courses",produces=MediaType.APPLICATION_XML_VALUE)
	public List<Course> getCourses() {
		return course.myListCourses();
	}
	
	
	// BUSCAMOS POR URL EL NOMBRE DEL CURSO
	@GetMapping(value="courses/{name}",produces=MediaType.APPLICATION_XML_VALUE)
	public List<Course> searchCourse(@PathVariable("name") String nam) {
		return course.searchCourses(nam);
	}
	

	// CODIGO QUEMADO PARA PODER VISUALIZAR JSON
	@GetMapping(value="course",produces=MediaType.APPLICATION_XML_VALUE)
	public Course getCourse() {
		return new Course("JavaScript", 20.0,10.0,24);
	}
	
	
	// ELIMINAMOS CURSO PIDIENDO NOMBRE POR URL
	@DeleteMapping(value="course/{name}")
	public List<Course> deleteCourse(@PathVariable("name") String name){
		return course.deleteCourse(name);
	}
	
	
	// CREAMOS CURSO
	@PostMapping(value="course",consumes=MediaType.APPLICATION_XML_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	public List<Course> postCourse(@RequestBody Course c) {
		return course.postCourse(c);
	}


}
