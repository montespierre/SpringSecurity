package com.montespierre.app.servicesecurity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.montespierre.app.entity.Empleado;
import com.montespierre.app.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceSecurity implements UserDetailsService{

	@Autowired
	private EmpleadoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Empleado emp = repo.findByNomEmp(username);
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDet = new User(emp.getNomEmp(), emp.getTelEmp(), roles);
		// De donde sacar datos de usuario
		return userDet;
	}

}
