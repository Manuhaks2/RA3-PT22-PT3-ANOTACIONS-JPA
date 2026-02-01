package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;

import javax.persistence.*;

@Entity //Hibernate la reconone
@DiscriminatorValue("STUDENT")
public class Student extends Person {

	@Column (name="studentCode")
	private String studentCode;

	// Constructor vacío (requerido por JPA)
	public Student() { }
	
	public Student(String name, String surname, int phoneNumber, String studentCode) 
	{
		super(name, surname, phoneNumber); // Inicializa los campos heredados de Person
		this.studentCode = studentCode;  // Inicializa el campo específico de Student
	}

	public String getStudentCode() { return studentCode; }
	public void setStudentCode(String studentCode) { this.studentCode = studentCode; }


	@Override
	public String toString() {
		return "Student [id: " + getId() + " | name: " + getName() + " | surname: " + getSurname() + " | phoneNumber: " + getPhoneNumber() + " | studentCode: " + studentCode + "]";
	}
	
	
	
}
