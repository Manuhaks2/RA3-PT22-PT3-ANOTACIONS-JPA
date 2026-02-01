package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity //Hibernate la reconone
@DiscriminatorValue("TEACHER")
public class Teacher extends Person {

	@Column (name="teacherCode")
	private String teacherCode;

	// Constructor vacío (requerido por JPA)
	public Teacher() { }
	
	public Teacher(String name, String surname, int phoneNumber, String teacherCode) 
	{
		super(name, surname, phoneNumber); // Inicializa los campos heredados de Person
		this.teacherCode = teacherCode;  // Inicializa el campo específico de Student
	}

	public String getTeacherCode() { return teacherCode; }
	public void setTeacherCode(String teacherCode) { this.teacherCode = teacherCode; }


	@Override
	public String toString() {
		return "Teacher [id: " + getId() + " | name: " + getName() + " | surname: " + getSurname() + " | phoneNumber: " + getPhoneNumber() + " | studentCode: " + teacherCode + "]";
	}
	
	
	
}
