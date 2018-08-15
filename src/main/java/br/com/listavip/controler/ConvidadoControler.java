package br.com.listavip.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.listavip.model.Convidado;
import br.com.listavip.repository.ConvidadoRepository;

@Controller 
public class ConvidadoControler  {
	private final static String LISTA_CONVIDADOS = "convidados";
	
	@Autowired
	private ConvidadoRepository repository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute( LISTA_CONVIDADOS, convidados);
		return "listaconvidados";
	}
	
	
	@RequestMapping(value = "salvarCandidato", method = RequestMethod.POST)
	public String salvaCandidato(@RequestParam("nome") String nome, @RequestParam("email") String email, 
			@RequestParam("telefone") String telefone, Model model) {
			
			Convidado novoConvidado = new Convidado(nome, email, telefone);
			repository.save(novoConvidado);
			
			Iterable<Convidado> convidados = repository.findAll();
			model.addAttribute( LISTA_CONVIDADOS, convidados);
			
		return "listaconvidados";
	}
}
