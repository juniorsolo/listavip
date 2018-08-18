package br.com.listavip.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listavip.model.Convidado;
import br.com.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	
	@Autowired
	private ConvidadoRepository repo;
	
	public Iterable<Convidado> findall(){
		try {
			Iterable<Convidado> convidados = repo.findAll();
			return convidados;
		}catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public Convidado findOne(Integer id) {
		try {
			Optional<Convidado> convidado = repo.findById(id);
			return !convidado.isPresent() ? null : convidado.get();
		}catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public void save(Convidado convidado) {
		try {
			repo.save(convidado);
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
