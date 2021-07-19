package com.ionic.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.ionic.api.entity.Cliente;
import com.ionic.api.repositorys.ClienteRepository;
import com.ionic.api.security.UserSecurity;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Cliente cli = clienteRepository.findByEmail(email);
		
		if(cli == null){
			throw new ResourceAccessException("Email não encontrado" + email);
		}
		
		return new UserSecurity(cli.getId(), cli.getEmail(),cli.getSenha(), cli.getPerfis());
	}

}
