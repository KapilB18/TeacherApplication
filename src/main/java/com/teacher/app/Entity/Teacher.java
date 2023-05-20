package com.teacher.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teacher1")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
	
	@Id
    @Column(name = "Id")	
	private String teacherId;
	@Column(name = "Name") 
	private String teacherName;
	@Column(name = "Department") 
	private String teacherDepa;
	@Column(name = "DateOfBirth") 
	private String dateObirth;

}
