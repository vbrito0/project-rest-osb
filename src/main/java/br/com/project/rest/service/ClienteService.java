package br.com.project.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.project.rest.model.Cliente;
import br.com.project.rest.model.Response;
import br.com.project.rest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private	ClienteRepository clienteRepository;
	
	public List<Cliente> clienteListar() {
		return clienteRepository.findAll();
	}
	
	public Response adicionarClientes(Cliente cliente) {
		Response response = new Response();
		clienteRepository.save(cliente);
		response.setMessage("Foi adicionado o(a) cliente " + cliente.getNome());
		return response;
	}
	
	public Response deletarCliente(Cliente cliente) {
		Response response = new Response();
		clienteRepository.delete(cliente);
		response.setMessage("O(A) cliente " + cliente.getNome() + " foi deletado");
		return response;
	}
}
