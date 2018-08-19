package br.com.listavip.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.enviaemail.EnviaEmail.EmailService;
import br.com.listavip.model.Convidado;
import br.com.listavip.service.ConvidadoService;

@Controller 
public class ConvidadoControler  {
	
	private final static String LISTA_CONVIDADOS = "convidados";
	
	@Autowired
	private ConvidadoService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/add")
	public ModelAndView add(Convidado convidado) {
		ModelAndView mv = new ModelAndView("/addconvidados");
		mv.addObject("convidado", convidado);
		return mv;
	}
	
	@RequestMapping("listaconvidados")
	public ModelAndView listaConvidados() {
		ModelAndView model = new ModelAndView("/listaconvidados");
		Iterable<Convidado> convidados = service.findall();
		model.addObject(LISTA_CONVIDADOS, convidados);
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Integer id) {
			service.delete(id);
			return this.listaConvidados();
	}
	
	@PostMapping(value = "/salvarCandidato")
	public ModelAndView salvaCandidato( Convidado convidado) {
		
			service.save(convidado);
			
			new EmailService().enviar(convidado.getNome(), convidado.getEmail());
						
		return this.listaConvidados();
	}
}
