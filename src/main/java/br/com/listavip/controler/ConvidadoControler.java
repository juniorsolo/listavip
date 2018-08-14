package br.com.listavip.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.listavip.model.Convidado;
import br.com.listavip.repository.ConvidadoRepository;

@Controller 
public class ConvidadoControler  {
	
	@Autowired
	private ConvidadoRepository repository;
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = repository.findAll();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
}
