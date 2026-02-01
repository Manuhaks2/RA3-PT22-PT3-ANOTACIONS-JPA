package es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain;
import javax.persistence.*;

@Entity
@Table(name = "car") // Cada subclase tiene su propia tabla
public class Car extends Vehicle {

	@Column (name="doors")
	private int doors;
	
	@Column (name="seats")
	private int seats;
	
	public Car() { }
	

	public Car(String brand, int year, float price, int doors, int seats) {
		super(brand, year, price); // Llama al constructor de Vehicle
		this.doors = doors;
		this.seats = seats;
	}

	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}


	
	@Override
	public String toString() {
		return "Car [id: " + getId() + " | brand: " + getBrand() + " | year: " + getYear() + " | price: " + getPrice() + " | doors: " + doors + " | seats: " + seats + "]";
	}
	
	
}