package com.teacher.app.Service;

import java.util.List;

import com.teacher.app.Entity.Teacher;


public interface TeacherService {

	Teacher createTeacher(Teacher teacher);
	
	Teacher updateTeacher(Teacher teacher);
	
	Teacher getTeacherByID(String Id);
	
	List<Teacher> getAllTeachers();
	
	void deleteByID(String id);
	
	
	
}
