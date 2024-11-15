package org.iesbelen.controlador;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /clientes como
//prefijo.
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;


    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //@RequestMapping(value = "/clientes", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping("") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Cliente> listaClientes = clienteService.listAll();
        model.addAttribute("listaClientes", listaClientes);

        return "clientes/clientes";

    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id) {

        Optional<Cliente> cliente = clienteService.find(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "clientes/detalle-cliente";
        } else {
            return "clientes/clientes";
        }

    }

    @GetMapping("/crear")
    public String crear (@ModelAttribute Cliente cliente, Model model){

        return "clientes/crear-cliente";

    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Optional<Cliente> cliente = clienteService.find(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "clientes/editar-cliente";
        } else {
            return "clientes/clientes";
        }

    }

    @PostMapping("/crear")
    public String submitCrear(@Valid @ModelAttribute Cliente cliente, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){
            model.addAttribute("cliente", cliente);
            model.addAttribute("toString", cliente.toString());
            return "clientes/crear-cliente";
        }

        clienteService.crear(cliente);

        return "/clientes/clientes" ;

    }

    @PostMapping("/editar/{id}")
    public RedirectView submitEditar(@ModelAttribute("cliente") Cliente cliente) {

        clienteService.update(cliente);

        return new RedirectView("/clientes");
    }

    @PostMapping("/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        clienteService.delete(id);

        return new RedirectView("/clientes");
    }

}
