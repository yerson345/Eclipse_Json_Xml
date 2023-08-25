package co.edu.ue.model;

import java.util.ArrayList;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement
public class Course {
	
	
	// VARIABLES
	private String name;
	private double duration;
	private double cost;
	private int ability;
	private ArrayList<Course> courses;

	
	// CREAMOS CONSTRUCTOR CON VARIABLES
	public Course(String name, double duration, double cost, int ability) {
		super();
		this.name = name;
		this.duration = duration;
		this.cost = cost;
		this.ability = ability;
	}
	
	public Course() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public int getAbility() {
		return ability;
	}


	public void setAbility(int ability) {
		this.ability = ability;
	}
	
	
	// CREAMOS UNA LISTA CON LOS CURSOS
	public ArrayList<Course> myListCourses() {
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(new Course("JavaScript", 20.0,10.0,24));
		courses.add(new Course("Java", 40.0,20.0,24));
		courses.add(new Course("PHP", 40.0,12.0,24));
		
		return (courses);
	}
	
	
	// CREAMOS METODO QUE BUSQUE EN LA LISTA EL CURSO
	public ArrayList<Course> searchCourses(String name) {
		ArrayList<Course> courses_aux = new ArrayList<>();
		ArrayList<Course> courses_return = new ArrayList<>();
		courses_aux = this.myListCourses();
		System.out.println("Metodo: " + name);
		for (Course course: courses_aux) {
			if(course.getName().contains(name)) {
				courses_return.add(course);
			}
		}
		
		return courses_return;
	}
	
	
	// METODO PARA AGREGAR CURSO
	public ArrayList<Course> postCourse(Course course) {
		ArrayList<Course> courses = new ArrayList<>();
		courses = this.myListCourses();
		courses.add(course);
		this.courses = courses;
		return this.courses;
	}
	
	
	// METODO PARA ELIMINAR CURSO
	public ArrayList<Course> deleteCourse(String name) {
		ArrayList<Course> courses = new ArrayList<>();
		courses = this.myListCourses();
		courses.removeIf(c->c.getName().equals(name));
		this.courses = courses;
		return this.courses;
	}
	
	

}
