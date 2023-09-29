package controlador;

import org.hibernate.*;
import org.hibernate.cfg.*;

import modelos.Empleado;


public class EmpleadoControlador {	
	
	//--------------------------------------------------------a//
	
	@SuppressWarnings("deprecation")
	public String createEmpleado(String apellidoEmpleado, String nombreEmpleado, String edadEmpleado, String sexoEmpleado, Double salarioEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			Empleado empleado = new Empleado(apellidoEmpleado, nombreEmpleado, edadEmpleado, sexoEmpleado, salarioEmpleado);
			session.beginTransaction();
			session.save(empleado);
			session.getTransaction().commit();				
			sessionFactory.close(); 		
			
			return "Se ha creado correctamente al Empleado: " + nombreEmpleado + " " + apellidoEmpleado;			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "No se puedo registrar al empleado, intente de nuevo.";		
}
	
	
	//-------------------------------------------------------------//
	
	@SuppressWarnings("deprecation")
	public String deleteEmpleado(int idEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idEmpleado);
			session.delete(empleado);
			session.getTransaction().commit();
			
			sessionFactory.close();
			
			return "Se ha eliminado correctamente al Empleado: " + idEmpleado;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se ha encontrado al empleado " + idEmpleado + ", intente nuevamente";
	}
	
	//----------------------------------------------------------//
	
	@SuppressWarnings("deprecation")
	public String updateEmpleado(int idEmpleado, String apellidoEmpleado, String nombreEmpleado, String edadEmpleado, String sexoEmpleado, Double salarioEmpleado) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idEmpleado);
			empleado.setApellidoEmpleado(apellidoEmpleado);
			empleado.setNombreEmpleado(nombreEmpleado);
			empleado.setEdadEmpleado(edadEmpleado);
			empleado.setSexoEmpleado(sexoEmpleado);
			empleado.setSalarioEmpleado(salarioEmpleado);			
			session.update(empleado);
			session.getTransaction().commit();					
			sessionFactory.close(); 
			
			return "Empleado " + idEmpleado + ", ha sido actualizado con éxito" + "\n\n" +
					"Apellido: " + apellidoEmpleado + "\n" +
					"Nombre: " + nombreEmpleado + "\n" +
					"Edad: " + edadEmpleado + "\n" +
					"Sexo: " + sexoEmpleado + "\n" +
					"Salario: " + salarioEmpleado;			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return "Error al actualizar al Empleado: " + idEmpleado;
	}
	
	//----------------------------------------------------------//
	
	public String readEmpleado(int idEmpleado) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			Empleado empleado = session.get(Empleado.class, idEmpleado);
			
			session.getTransaction().commit();
			sessionFactory.close();
			
			return empleado.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "No se ha podido encontrar al Empleado: " + idEmpleado;
	}
}
