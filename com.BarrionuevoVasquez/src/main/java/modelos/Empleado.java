package modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@Column(name = "idEmpleado")
	private int idEmpleado;	
	@Column(name = "apellidoEmpleado")
	private String apellidoEmpleado;	
	@Column(name = "nombreEmpleado")
	private String nombreEmpleado;	
	@Column(name = "edadEmpleado")
	private String edadEmpleado;	
	@Column(name = "sexoEmpleado")
	private String sexoEmpleado;	
	@Column(name = "salarioEmpleado")
	private Double salarioEmpleado;
	public Empleado() {
	}
	public Empleado(String apellidoEmpleado, String nombreEmpleado, String edadEmpleado, String sexoEmpleado,
			Double salarioEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
		this.nombreEmpleado = nombreEmpleado;
		this.edadEmpleado = edadEmpleado;
		this.sexoEmpleado = sexoEmpleado;
		this.salarioEmpleado = salarioEmpleado;
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}
	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado = apellidoEmpleado;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}
	public String getEdadEmpleado() {
		return edadEmpleado;
	}
	public void setEdadEmpleado(String edadEmpleado) {
		this.edadEmpleado = edadEmpleado;
	}
	public String getSexoEmpleado() {
		return sexoEmpleado;
	}
	public void setSexoEmpleado(String sexoEmpleado) {
		this.sexoEmpleado = sexoEmpleado;
	}
	public Double getSalarioEmpleado() {
		return salarioEmpleado;
	}
	public void setSalarioEmpleado(Double salarioEmpleado) {
		this.salarioEmpleado = salarioEmpleado;
	}
	
	@Override
	public String toString() {
		return "Empleado [IdEmpleado=" + idEmpleado + ", Apellidos=" + apellidoEmpleado + ", Nombres=" + nombreEmpleado + ", Edad="
				+ edadEmpleado + ", Sexo=" + sexoEmpleado + ", Salario=" + salarioEmpleado + "]";
	}
}
