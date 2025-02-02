package org.iesbelen.controlador;

import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.service.ComercialService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /comerciales como
//prefijo.
//@RequestMapping("/comerciales")
public class ComercialController {

	private ComercialService comercialService;


	//Se utiliza inyección automática por constructor del framework Spring.
	//Por tanto, se puede omitir la anotación Autowired
	//@Autowired
	public ComercialController(ComercialService comercialService) {
		this.comercialService = comercialService;
	}

	//@RequestMapping(value = "/comercial", method = RequestMethod.GET)
	//equivalente a la siguiente anotación
	@GetMapping("/comerciales") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
	public String listar(Model model) {

		List<Comercial> listaComercials =  comercialService.listAll();
		model.addAttribute("listaComercials", listaComercials);

		return "/comercial/comerciales";

	}
	/*Detalle de un comercial*/
	@GetMapping("/comerciales/{id}")
	public String detalle(Model model, @PathVariable Integer id) {

		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);

		List<PedidoDTO> pedidosDTO = comercialService.listPedidosDTO(id);
		model.addAttribute("pedidosDTO", pedidosDTO);

		int totalPedidos = comercialService	.getTotalPedidos();
		model.addAttribute("totalPedidos", totalPedidos);

		double porcentajePedidos = comercialService.getPorcentajePedidos(id);
		model.addAttribute("porcentajePedidos", porcentajePedidos);
		return "/comercial/detalle-comercial";
	}

	@GetMapping("/comerciales/crear")
	public String create(Model model) {

		Comercial comercial = new Comercial();
		model.addAttribute("comercial", comercial);

		return "/comercial/crear-comercial";
	}

	@PostMapping("/comerciales/crear")
	public RedirectView submitCrear(@ModelAttribute("comercial") Comercial comercial) {

		comercialService.newComercial(comercial);

		return new RedirectView("/comerciales");

	}

	/*Editar un comercial*/
	@GetMapping("comerciales/editar/{id}")
	public String editar(Model model, @PathVariable Integer id) {

		Comercial comercial = comercialService.one(id);
		model.addAttribute("comercial", comercial);
		return "comercial/editar-comercial";
	}
	@PostMapping("/comerciales/editar/{id}")
	public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {

		comercialService.replaceComercial(comercial);

		return new RedirectView("/comerciales");

	}
	/*Borrar un comercial*/
	@PostMapping("/comerciales/borrar/{id}")
	public RedirectView submitBorrar(@PathVariable Integer id) {

		comercialService.deleteComercial(id);

		return new RedirectView("/comerciales");
	}


}