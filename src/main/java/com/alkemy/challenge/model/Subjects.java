package com.alkemy.challenge.model;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Subjects")
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@OneToOne
	@JoinColumn(name="idprofessor")
	private Professor professor;
	@Column(name="number_student")
	private Integer numberStudent;
	private String description;
	@Column(name="time")
	private Time time;
	

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setTime(Time time) {
		this.time = time;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	public Integer getNumberStudent() {
		return numberStudent;
	}
	
	public void setNumberStudent(Integer numberStudent) {
		this.numberStudent = numberStudent;
	}
	
	public Date getTime() {
		return time;
	}
	
	@Override
	public String toString() {
		return "Subjects [id=" + id + ", name=" + name + ", professor=" + professor + ", numberStudent=" + numberStudent
				+ ", description=" + description + ", time=" + time + "]";
	}

	public void setTime(Date parse) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
