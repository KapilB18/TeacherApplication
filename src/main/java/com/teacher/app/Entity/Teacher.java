package com.teacher.app.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.core.sym.Name;

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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String teacherId;
	@Column(name = "Name") 
	private String teacherName;
	@Column(name = "Department") 
	private String teacherDepa;
	@Column(name = "DateOfBirth") 
	private String dateObirth;

	/*
	 * public int hashCode() { 
	 *    final int prime=31; 
	 *    int result =1; 
	 *    result = prime * result + teacherId; 
	 *    result = prime * result + ((teacherName == null) ? 0 : teacherName.hashCode()); 
	 *    result = prime * result + teacherDepa; 
	 *    return result; 
	 *    }
	 */
	
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(this == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Teacher other= (Teacher) obj;
		if(teacherId != other.teacherId)
			return false;
		if(teacherName == null)
		{
			if(other.teacherName != null)
				return false;
		}
		else if(teacherName.equals(other.teacherName))
		{
			return false;			
		}
		if(teacherDepa != other.teacherDepa)
			return false;
		return true;
	}
}
