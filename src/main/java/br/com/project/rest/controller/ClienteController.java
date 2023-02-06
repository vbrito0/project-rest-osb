package br.com.project.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.project.rest.model.Cliente;
import br.com.project.rest.model.Response;
import br.com.project.rest.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping(value = "/adicionar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody Response adicionar(@RequestBody Cliente cliente) {
		Response response = new Response();
		clienteRepository.save(cliente);
		response.setMessage("Foi adicionado o(a) cliente " + cliente.getNome());
		return response;
	}
	
	@DeleteMapping(value = "/deletar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response delete(@RequestBody Cliente cliente) {
		Response response = new Response();
		clienteRepository.delete(cliente);
		response.setMessage("O(A) cliente " + cliente.getNome() + " foi deletado");
		return response;
		
	}
}
