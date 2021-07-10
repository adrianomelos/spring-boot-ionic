package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ionic.api.entity.Estado;
import com.ionic.api.repositorys.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	
RestTemplate c = new RestTemplate();	
	
	public Estado gravarUfLocal() {
		List<Estado> list = estadoRepository.findAll();
		if(list.size() < 27) {
			list.removeAll(list);
			
			String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";	
			Estado[] responseEntity = c.getForObject(url, Estado[].class);
			
			for (Estado u : responseEntity){
				Estado f = new Estado();
				f.setNome(u.getNome());
				f.setSigla(u.getSigla());
				f.setIdIbge(u.getId());
				estadoRepository.save(f);
			}
		}
		
		return null;
	}

	public List<Estado> findAllUf() {
		return estadoRepository.findAll();
	}

	public Optional<Estado> findByUfId(Long idUf) {
		return estadoRepository.findById(idUf);
	}
}
