package com.ionic.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ionic.api.entity.Cidade;
import com.ionic.api.entity.Estado;
import com.ionic.api.repositorys.CidadeRepository;
import com.ionic.api.repositorys.EstadoRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepository estadoRepository;
	
	RestTemplate c = new RestTemplate();

	public Cidade gravarUfLocal() {
		
		List<Cidade> listCity = cidadeRepository.findAll();

		if (listCity.size() < 100)

		{
			cidadeRepository.deleteAll(listCity);

			List<Estado> listUF = estadoRepository.findAll();

			for (Estado u : listUF) {
				String url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + u.getIdIbge()
						+ "/municipios";
				Cidade[] responseEntity = c.getForObject(url, Cidade[].class);

				for (Cidade city : responseEntity) {
					Cidade c = new Cidade();
					c.setNome(city.getNome());
					c.setEstado(new Estado(u.getId(), null, null, null, null));
					cidadeRepository.save(c);
				}
			}
		}
		return null;
	}

	public List<Cidade> findByCityUF(Long uf) {
		return cidadeRepository.findByEstadoId(uf);
	}

	public Optional<Cidade> findByCityId(Long id) {
		return cidadeRepository.findById(id);
	}
}
