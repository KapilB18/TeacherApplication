package com.teacher.app.ServiceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teacher.app.Entity.Teacher;
import com.teacher.app.Repository.TeacherRepository;
import com.teacher.app.Service.TeacherService;
import com.teacher.app.exceptions.ResourceNotFoundException;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher createTeacher(Teacher teacher) {
		String uniqueId = UUID.randomUUID().toString();
		teacher.setTeacherId(uniqueId);
		return teacherRepository.save(teacher);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {

		Teacher existingTeacher = teacherRepository.findById(teacher.getTeacherId()).orElseThrow(()->new ResourceNotFoundException());
		existingTeacher.setTeacherName(teacher.getTeacherName());
		existingTeacher.setTeacherDepa(teacher.getTeacherDepa());
		existingTeacher.setDateObirth(teacher.getDateObirth());
		
		 Teacher updatedTeacher = teacherRepository.save(existingTeacher);
		 return updatedTeacher;

	}

	@Override
	public Teacher getTeacherByID(String Id) {
		 Teacher teacher = teacherRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException());
		return teacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		 List<Teacher> allteachers = teacherRepository.findAll();
		return allteachers;
	}

	@Override
	public void deleteByID(String id) {
		 teacherRepository.deleteById(id);
	
	}

}
