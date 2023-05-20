package com.teacher.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teacher.app.Entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String>{

}
