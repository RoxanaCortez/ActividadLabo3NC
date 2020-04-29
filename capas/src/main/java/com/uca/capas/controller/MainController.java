package com.uca.capas.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.Student;

@Controller
public class MainController {
	
	//arreglo de estudiantes
	private List<Student> students = new ArrayList<Student>();
	
	//Ejemplo 1 ResponseBody
	@GetMapping(path = "/ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE) //devuelve texto plano en lugar de texto http
	@ResponseBody
	public String ejemplo1() {
		return "Bienvenidos\n" + "Programación N-Capas";
	}
	
	//Ejemplo 2 ResponseBody (generación de un Jason)
	@GetMapping("/ejemplo2")
	public @ResponseBody List<Student> ejemplo2(){	//lista de estudiantes
		return Arrays.asList(	//devuelve arreglo de estudiantes utilizando la lista, por lo obtendremos una lista de estudiantes
				new Student("Nombre1", "Apellido", "10/10/1992","Carrera X", true),
				new Student("Nombre2", "Apellido", "10/10/1992", "Ingeniería en Limones", false)
				);
	}
	
	
	@GetMapping("/inicio") 	//punto de inicio
	public String inicio(Student student) {
		return "index";
	}
	
	
	@PostMapping("/formData") 
	//devolveremos un ModelAndView
	public ModelAndView procesar(Student student) {//recibimos el objeto mappeado student que estaba en el formulario 
		students.add(student);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		mav.addObject("student", new Student()); //con mav puedo añadir distintos objetos a mi vista 
		return mav;
	}
	
	@GetMapping("/listado") //nos llevara al listado
	public ModelAndView listado() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("listado");
		mav.addObject("studentList", this.students); //enviamos la lista que hemos ido guardando en fromData
		return mav;
	}
	

}
