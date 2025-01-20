package org.iesbelen.controlador;

import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
//@RequestMapping("/comercial")
public class ComercialController {

	private ComercialService clienteService;


	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialController(ComercialService clienteService) {
		this.clienteService = clienteService;
	}
	
	//@RequestMapping(value = "/comercial", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/comercial") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {
		
		List<Comercial> listaComercials =  clienteService.listAll();
		model.addAttribute("listaComercials", listaComercials);
				
		return "comercial";
		
	}
}