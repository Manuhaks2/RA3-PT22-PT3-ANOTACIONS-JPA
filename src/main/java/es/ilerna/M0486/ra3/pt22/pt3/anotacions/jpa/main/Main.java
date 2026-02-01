package es.ilerna.M0486.ra3.pt22.pt3.anotacions.jpa.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.ilerna.M0486.ra3.pt1.intro.orm.domain.Serie;
import es.ilerna.M0486.ra3.pt1.intro.orm.main.HibernateSession;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Car;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Motorcycle;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Person;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Plane;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Student;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Teacher;
import es.ilerna.M0486.ra3.pt22.anotacions.jpa.domain.Vehicle;

public class Main 
{

	private static List<Person> people = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();
	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		int opcio;

		do 
		{
			System.out.println("\n===== MENÚ PRINCIPAL =====");
			System.out.println("1) Fase 1: Crear dades de prova");
			System.out.println("2) Fase 2: Treure vehicles de persones");
			System.out.println("3) Fase 3: Actualitzar un vehicle");
			System.out.println("0) Sortir");
			System.out.print("Escull una opció: ");

			opcio = sc.nextInt();
			sc.nextLine();

			switch (opcio) 
			{
				case 1:
					fase1();
					break;
				case 2:
					fase2();
					break;
				case 3:
					fase3();
					break;
				case 0:
					System.out.println("Fins aviat!");
					break;
				default:
					System.out.println("Opció incorrecta.");
			}

		} while (opcio != 0);

		sc.close();
		HibernateSession.getSessionFactory().close();
	}
	
	private static void fase1() 
	{
		Session session = HibernateSession.getSessionFactory().openSession(); //El hibernate te borra todas las tablas SI existen y luego te las vuelve a crear para que esten limpias de datos.
		Transaction tx = session.beginTransaction();
		
		try 
		{
			Student student1 = new Student("Anna", "Lopez", 111111111, "STU001");
			Student student2 = new Student("Jordi", "Martinez", 222222222, "STU002");
			Student student3 = new Student("Clara", "Sanchez", 333333333, "STU003");
			
			Teacher teacher1 = new Teacher("Joan", "Perez", 444444444, "TEA001");
			Teacher teacher2 = new Teacher("Maria", "Gomez", 555555555, "TEA002");
			Teacher teacher3 = new Teacher("Pere", "Ruiz", 666666666, "TEA003");
			
			
			
			
			session.persist(student1);
			session.persist(student2);
			session.persist(student3);
			
			session.persist(teacher1);
			session.persist(teacher2);
			session.persist(teacher3);
			
			
			
			
			Car car1 = new Car("Toyota", 2020, 18000, 5, 5);
			Car car2 = new Car("Ford", 2019, 15000, 3, 4);
			
			Plane plane1 = new Plane("Cessna", 2015, 120000, 11111, true);
			Plane plane2 = new Plane("Boeing", 2010, 900000, 22222, false);
			
			Motorcycle motorcycle1 = new Motorcycle("Yamaha", 2021, 9000, false);
			Motorcycle motorcycle2 = new Motorcycle("Harley-Davidson", 2018, 20000, true);
			
			
			car1.setPerson(student1);
			car2.setPerson(teacher2);
			
			plane1.setPerson(teacher1);
			plane2.setPerson(student3);
			
			motorcycle1.setPerson(student2);
			motorcycle2.setPerson(teacher3);
			
			
			
			
			session.persist(car1);
			session.persist(car2);
			
			session.persist(plane1);
			session.persist(plane2);
			
			session.persist(motorcycle1);
			session.persist(motorcycle2);
			
			
			tx.commit(); 
			System.out.println("Fase 1 realizado");
			
			
			
		}
		catch (Exception e)
		{
			if (tx != null) { tx.rollback(); }
			e.printStackTrace();
		}
		
		finally
		{
			//Cerrar recursos
			if (session != null) { session.close(); }
		}
		
	}
	
	private static void fase2() 
	{
		Session session = HibernateSession.getSessionFactory().openSession(); //El hibernate te borra todas las tablas SI existen y luego te las vuelve a crear para que esten limpias de datos.
		Transaction tx = session.beginTransaction();

		try 
		{
			
			Vehicle vehicle = session.get(Vehicle.class,1);
			
			if(vehicle !=null) {
				vehicle.setPerson(null);
				System.out.println("Relacion quitada");
			}
			
			else {
				System.out.println("no se ha encontrado el vehiculo");
			}
			
			tx.commit(); 
			
		}
		catch (Exception e)
		{
			if (tx != null) { tx.rollback(); }
			e.printStackTrace();
		}
		
		finally
		{
			//Cerrar recursos
			if (session != null) { session.close(); }
		}
		
		
	}
	
	private static void fase3() 
	{
		Session session = HibernateSession.getSessionFactory().openSession(); //El hibernate te borra todas las tablas SI existen y luego te las vuelve a crear para que esten limpias de datos.
		Transaction tx = session.beginTransaction();

		
		try 
		{
			
			Vehicle vehicle = session.get(Vehicle.class,1);
			
			
			vehicle.setBrand("Seat");
			vehicle.setYear(2022);
			vehicle.setPrice(19999);
			
			
			System.out.println("Datos actualizados");
			tx.commit(); 

		}
		catch (Exception e)
		{
			if (tx != null) { tx.rollback(); }
			e.printStackTrace();
		}
		
		finally
		{
			//Cerrar recursos
			if (session != null) { session.close(); }
		}
	}
}
