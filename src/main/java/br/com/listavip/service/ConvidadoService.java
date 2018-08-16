package br.com.listavip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.listavip.model.Convidado;
import br.com.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadoService {
	
	@Autowired
	private ConvidadoRepository repo;
	
	public Iterable<Convidado> obterTodos(){
		try {
			Iterable<Convidado> convidados = repo.findAll();
			return convidados;
		}catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}
	
	public void salvar(Convidado convidado) {
		try {
			repo.save(convidado);
		}catch (Exception e) {
			e.getStackTrace();
		}
	}
}
