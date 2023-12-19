package br.com.project.rest.service;

import java.util.List;
import java.util.Objects;

import br.com.project.rest.dto.ClienteDto;
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
	
	public Response adicionarClientes(ClienteDto clienteDto) {
		Response response = new Response();
		Cliente cliente = ClienteDto.toCliente(clienteDto);
		clienteRepository.save(cliente);
		response.setMessage("Foi adicionado o(a) cliente " + cliente.getNome());
		return response;
	}
	
	public Response deletarCliente(Long idCliente) {
		Response response = new Response();
		Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new IllegalArgumentException("Usuario não encontrado!"));
		clienteRepository.delete(cliente);
		response.setMessage("O(A) cliente " + cliente.getNome() + " foi deletado");
		return response;
	}

	public Response atualizarCliente(Long idCliente, ClienteDto clienteDto) {
		Response response = new Response();
		Cliente clienteAntigo = clienteRepository.findById(idCliente).orElseThrow(() -> new IllegalArgumentException("Nenhum usuario foi encontrado com esse id."));
		Cliente clienteAtualizado = Cliente.builder()
				.id(idCliente)
				.nome(Objects.nonNull(clienteDto.getNome()) ? clienteDto.getNome() : clienteAntigo.getNome())
				.idade(Objects.nonNull(clienteDto.getIdade()) ? clienteDto.getIdade() : clienteAntigo.getIdade())
				.build();
		clienteRepository.save(clienteAtualizado);
		response.setMessage("Cliente com id " + idCliente + " foi  atualizado!");
		return response;
	}
}
