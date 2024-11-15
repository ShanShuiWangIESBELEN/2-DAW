package org.iesbelen.service;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.dao.ComercialDAO;
import org.iesbelen.dao.PedidoDAO;
import org.iesbelen.modelo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class ComercialService {

    private ComercialDAO comercialDAO;
    private PedidoDAO pedidoDAO;
    private ClienteDAO clienteDAO;

    @Autowired
    public ComercialService(ComercialDAO comercialDAO, ClienteDAO clienteDAO, PedidoDAO pedidoDAO) {
        this.comercialDAO = comercialDAO;
        this.pedidoDAO = pedidoDAO;
        this.clienteDAO = clienteDAO;
    }

    public List<Comercial> listAll() {return comercialDAO.getAll();}

    public Optional<Comercial> find(Integer id) {
        return comercialDAO.find(id);
    }
    public void crear(Comercial comercial) {
        comercialDAO.create(comercial);
    }
    public void update(Comercial comercial) {
        comercialDAO.update(comercial);
    }
    public void delete(int id) {comercialDAO.delete(id);}

    public ComercialDTO obtenerDto(Integer id){
        Optional<Comercial> comercial = comercialDAO.find(id);

        if (comercial.isPresent()){
           /* comercialDTO.setId(comercial.get().getId());
            comercialDTO.setNombre(comercial.get().getNombre());
            comercialDTO.setApellido1(comercial.get().getApellido1());
            comercialDTO.setApellido2(comercial.get().getApellido2());
            comercialDTO.setComision(comercial.get().getComision());*/

            ComercialDTO comercialDTO = ComercialMapper.INSTANCE.comercialToComercialDTO(comercial.get());

            List<Pedido> pedidoList = pedidoDAO.getAll(id);
            int totalPedidos = pedidoList.size();
            Double mediaPedidosCoste = pedidoList.stream().mapToDouble(Pedido::getTotal).average().orElse(0.0);
            mediaPedidosCoste = (double) Math.round(mediaPedidosCoste);
            double totalPedidosCoste = pedidoList.stream().mapToDouble(Pedido::getTotal).sum();
            comercialDTO.setTotalPedidos(totalPedidos);
            comercialDTO.setMediaPedidosCoste(mediaPedidosCoste);
            comercialDTO.setTotalPedidosCoste(totalPedidosCoste);


            for (Pedido pedido : pedidoList){
                Optional<Cliente> optCliente = clienteDAO.find(pedido.getId_cliente());
                optCliente.ifPresent(cliente -> pedido.setNombreCliente(cliente.getNombre()));
            }
            comercialDTO.setListaPedidos(pedidoList);
            return comercialDTO;
        }

        return null;
    }

    public Double obtenerPedidoMax(Integer id){
        ComercialDTO comercialDTO = this.obtenerDto(id);
        List<Pedido> pedidoList = comercialDTO.getListaPedidos();

        return pedidoList.stream().mapToDouble(Pedido::getTotal).max().orElse(0.0);
    }

    public Double obtenerPedidoMin(Integer id){
        ComercialDTO comercialDTO = this.obtenerDto(id);
        List<Pedido> pedidoList = comercialDTO.getListaPedidos();

        return pedidoList.stream().mapToDouble(Pedido::getTotal).min().orElse(0.0);
    }
}
