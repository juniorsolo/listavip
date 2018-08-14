package br.com.listavip.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConvidadoControler  {
	
	@RequestMapping("listaconvidados")
	public String listaConvidados() {
		return "listaconvidados";
	}
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	

	
}
