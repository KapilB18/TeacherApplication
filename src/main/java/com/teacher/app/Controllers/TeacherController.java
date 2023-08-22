package com.teacher.app.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teacher.app.Entity.Teacher;
import com.teacher.app.Service.TeacherService;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {
	
	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/get-server-port")
	public String getServerPort() {
		System.out.println(" My Server Port is "+ serverPort);
		return "My Server port is = " + serverPort;
	}
	
	@Autowired
	private TeacherService teacherservice;
	

	@PostMapping(value = "/create")
	ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
		
		Teacher teacher2 = teacherservice.createTeacher(teacher);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacher2);
		
	}
	
	@PutMapping(value = "/update-teacher/{teacherID}") 
	ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher, 
			                              @PathVariable String teacherID)
	                                      throws Exception {
		
		 teacher.setTeacherId(teacherID);
		 Teacher updateTeacher = teacherservice.updateTeacher(teacher);	
		 
		return ResponseEntity.status(HttpStatus.OK).body(updateTeacher);
	}
	
	@GetMapping("/get-teacher-by-id/{teacherId}")
	ResponseEntity<Teacher> getTeacherById(@PathVariable("teacherId") String Id){
		
		Teacher teacherByID = teacherservice.getTeacherByID(Id);
		return ResponseEntity.status(HttpStatus.FOUND).body(teacherByID);
	}
	
	
	@GetMapping(value = "/get-all-teachers")
	ResponseEntity<List<Teacher>> getAllTeachers(){
		
		List<Teacher> allTeachers = teacherservice.getAllTeachers();
		return ResponseEntity.status(HttpStatus.OK).body(allTeachers);
	}
	
	@DeleteMapping(value = "/delete-by-id/{teacherID}")
	ResponseEntity<String> deleteById(@PathVariable(value = "teacherID") String teacherId){
		 teacherservice.deleteByID(teacherId);
		 return ResponseEntity.status(HttpStatus.OK).body("Data with id : "+teacherId+" deleted successfully");
	}
}
