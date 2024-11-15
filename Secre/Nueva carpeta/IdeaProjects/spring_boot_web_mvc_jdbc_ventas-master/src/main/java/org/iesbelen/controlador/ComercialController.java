package org.iesbelen.controlador;

import java.util.List;
import java.util.Optional;

import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dao.PedidoDAOImpl;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.ComercialDTO;
import org.iesbelen.modelo.Pedido;
import org.iesbelen.service.ComercialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
//Se puede fijar ruta base de las peticiones de este controlador.
//Los mappings de los métodos tendrían este valor /comercial como
//prefijo.
@RequestMapping("/comercial")
public class ComercialController {

    private ComercialService comercialService;

    @Autowired
    public ComercialController(ComercialService comercialService) {
        this.comercialService = comercialService;
    }

    //@RequestMapping(value = "/comercial", method = RequestMethod.GET)
    //equivalente a la siguiente anotación
    @GetMapping("") //Al no tener ruta base para el controlador, cada método tiene que tener la ruta completa
    public String listar(Model model) {

        List<Comercial> listaComercial =  comercialService.listAll();
        model.addAttribute("listaComercial", listaComercial);

        return "comercial/comercial";

    }

    @GetMapping("/{id}")
    public String detalle(Model model, @PathVariable Integer id) {

        //Optional<Comercial> comercial = comercialService.find(id);
        /*if (comercial.isPresent()) {
            model.addAttribute("comercial", comercial.get());
            return "comercial/detalle-comercial";
        } else {
            return "comercial/comercial";
        }*/

        ComercialDTO comercialDTO = comercialService.obtenerDto(id);
        double max = comercialService.obtenerPedidoMax(id);
        double min = comercialService.obtenerPedidoMin(id);

        model.addAttribute("comercial", comercialDTO);
        model.addAttribute("max", max);
        model.addAttribute("min", min);

        return "comercial/detalle-comercial";

    }

    @GetMapping("/crear")
    public String crear (Model model){

        Comercial comercial = new Comercial();
        model.addAttribute("comercial", comercial);

        return "comercial/crear-comercial";
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {

        Optional<Comercial> comercial = comercialService.find(id);
        if (comercial.isPresent()) {
            model.addAttribute("comercial", comercial.get());
            return "comercial/editar-comercial";
        } else {
            return "comercial/comercial";
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////


    @PostMapping("/crear")
    public RedirectView submitCrear(@ModelAttribute("comercial") Comercial comercial) {

        comercialService.crear(comercial);

        return new RedirectView("/comercial") ;

    }

    @PostMapping("/editar/{id}")
    public RedirectView submitEditar(@ModelAttribute("comercial") Comercial comercial) {

        comercialService.update(comercial);

        return new RedirectView("/comercial");
    }

    @PostMapping("/borrar/{id}")
    public RedirectView submitBorrar(@PathVariable Integer id) {

        comercialService.delete(id);

        return new RedirectView("/comercial");
    }

}