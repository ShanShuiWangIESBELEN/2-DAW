package org.iesbelen.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.dto.PedidoDTO;
import org.iesbelen.mapstruct.PedidoMapper;
import org.iesbelen.modelo.Cliente;
import org.iesbelen.modelo.Comercial;
import org.iesbelen.modelo.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteDAO clienteDAO;

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private PedidoDAO pedidoDAO;

    @Autowired
    private ComercialDAO comercialDAO;

    //Se utiliza inyección automática por constructor del framework Spring.
    //Por tanto, se puede omitir la anotación Autowired
    //@Autowired
    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> listAll() {

        return clienteDAO.getAll();

    }

    public void newCliente(Cliente cliente) {

        clienteDAO.create(cliente);

    }
    public Cliente one(Integer id) {
        Optional<Cliente> optFab = clienteDAO.find(id);
        if (optFab.isPresent())
            return optFab.get();
        else
            return null;
    }
    public void replaceCliente(Cliente cliente) {
        clienteDAO.update(cliente);
    }
    public void deleteCliente(int id) {
        // ¿Está seguro de que quiere eliminar al cliente? Se borrarán también todos sus pedidos

        // Sí
        List<Pedido> pedidos = pedidoDAO.getAllByCliente(id);
        pedidos.forEach(p -> pedidoDAO.delete(p.getId()));
        clienteDAO.delete(id);

        // No
        // Borrado cancelado
    }
    public List<PedidoDTO> listPedidosDTO(int idCliente) {

        List<Comercial> comerciales = comercialDAO.getAll();
        List<Pedido> pedidos = pedidoDAO.getAllByCliente(idCliente);
        pedidos.sort((a, b) -> b.getFecha().compareTo(a.getFecha()));

        List<PedidoDTO> pedidosDTO = new ArrayList<>();

        for (Pedido p : pedidos) {
            int idC = p.getIdComercial();
            for (Comercial c : comerciales) {
                if (c.getId() == idC) {
                    pedidosDTO.add(pedidoMapper.pedidoAPedidoDTO(p, "", c.getNombre() + " " + c.getApellido1()
                            + " " + (c.getApellido2() != null ? c.getApellido2() : "")));
                }
            }
        }
        return pedidosDTO;
    }



}
