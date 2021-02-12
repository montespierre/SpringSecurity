package com.montespierre.app.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado{


	@Id
	@Column(name="idEmpleado")
	private Long idEmpleado;
	
	@Column(name="nomEmp")
	private String nomEmp;
	
	@Column(name="puestoEmp")
	private String puestoEmp;
	
	@Column(name="telEmp")
	private String telEmp;
	
	public Empleado() {
		idEmpleado = 0L;
		nomEmp = "";
		puestoEmp = "";
		telEmp = "";
	}

	public Long getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(Long idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public String getPuestoEmp() {
		return puestoEmp;
	}

	public void setPuestoEmp(String puestoEmp) {
		this.puestoEmp = puestoEmp;
	}

	public String getTelEmp() {
		return telEmp;
	}

	public void setTelEmp(String telEmp) {
		this.telEmp = telEmp;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nomEmp=" + nomEmp + ", puestoEmp=" + puestoEmp + ", telEmp="
				+ telEmp + "]";
	}
	
		

}
