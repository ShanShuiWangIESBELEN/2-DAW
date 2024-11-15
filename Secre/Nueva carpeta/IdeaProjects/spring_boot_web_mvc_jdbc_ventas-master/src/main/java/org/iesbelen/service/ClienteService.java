package org.iesbelen.service;

import java.util.List;
import java.util.Optional;

import org.iesbelen.dao.ClienteDAO;
import org.iesbelen.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	private ClienteDAO clienteDAO;
	

	@Autowired
	public ClienteService(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}
	
	public List<Cliente> listAll() {
		return clienteDAO.getAll();
	}
	public Optional<Cliente> find(Integer id) {
		return clienteDAO.find(id);
	}
	public void crear(Cliente cliente) {
		clienteDAO.create(cliente);
	}
	public void update(Cliente cliente) {
		clienteDAO.update(cliente);
	}
	public void delete(int id) {
		clienteDAO.delete(id);
	}
}
