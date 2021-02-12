package com.montespierre.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.montespierre.app.entity.Empleado;
import com.montespierre.app.repository.EmpleadoRepository;

@SpringBootTest
class CrudWeimontApplicationTests {

	@Autowired
	private EmpleadoRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearEmpleado() {
		Empleado emp = new Empleado();
		
		//entrada
		emp.setIdEmpleado((long)18);
		emp.setNomEmp("juliogranda");
		emp.setPuestoEmp("vendedor");
		emp.setTelEmp(encoder.encode("2322715"));
		
		//proceso
		Empleado retorno = repo.save(emp);
		//salida
		assertTrue(retorno.getTelEmp().equalsIgnoreCase(emp.getTelEmp()));
	}

}
