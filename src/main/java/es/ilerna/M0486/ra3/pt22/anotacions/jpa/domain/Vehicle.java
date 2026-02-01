package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;
import javax.persistence.*;




@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED) // Herencia: cada subclase tendrá su tabla
public class Vehicle {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //MUY IMPORTANTE LO DE GENERATION TYPE SINO AL REGISTRAR +1 EN LA BD, PETA
	@Column (name="id")
	private int id;
	
	@Column (name="brand")
	private String brand;
	
	@Column (name="year")
	private int year;
	
	@Column (name="price")
	private float price;
	
	
	
	
	@ManyToOne
	@JoinColumn(name = "person_id") // Columna FK que apunta a Person
	private Person person;
	
	
	// Constructor vacío
	public Vehicle() { }
	
	
	public Vehicle(String brand, int year, float price) 
	{
		this.brand = brand;
		this.year = year;
		this.price = price;
	}



	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Person getPerson() { 
		return person; 
	}
	public void setPerson(Person person) { 
		this.person = person; 
	}
	
	
	@Override
	public String toString() {
		return "Vehicle [id: " + id + " | brand: " + brand + " | year: " + year + " | price: " + price + " | person_id: " + (person != null ? person.getId() : "null") + "]";
	}
	
	
	
	
}