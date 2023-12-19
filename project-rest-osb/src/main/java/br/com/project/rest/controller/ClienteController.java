package br.com.project.rest.controller;

import java.util.List;

import br.com.project.rest.dto.ClienteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import br.com.project.rest.model.Cliente;
import br.com.project.rest.model.Response;
import br.com.project.rest.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Cliente> listar() {
		return clienteService.clienteListar();
	}

	@PostMapping(value = "/adicionar", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.CREATED)
	public @ResponseBody Response adicionar(@RequestBody ClienteDto cliente) {
		return clienteService.adicionarClientes(cliente);
	}

	@PutMapping(value = "/atualizar/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response atualizar(@PathVariable("/idCliente") Long idCliente ,@RequestBody ClienteDto cliente) {
		return clienteService.atualizarCliente(idCliente, cliente);
	}

	@DeleteMapping(value = "/deletar/{idCliente}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody Response delete(@PathVariable Long idCliente) {
		return clienteService.deletarCliente(idCliente);
		
	}
}
