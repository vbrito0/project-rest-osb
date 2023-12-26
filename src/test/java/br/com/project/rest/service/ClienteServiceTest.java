package br.com.project.rest.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.project.rest.dto.ClienteDto;
import br.com.project.rest.fixture.ClienteDTOFixture;
import br.com.project.rest.fixture.ClienteFixture;
import br.com.project.rest.model.Cliente;
import br.com.project.rest.model.Response;
import br.com.project.rest.repository.ClienteRepository;

public class ClienteServiceTest {
	
	@InjectMocks
	private ClienteService clienteService;
	
	@Mock
	private ClienteRepository clienteRepository;
	
	private TestInfo info;
	
	@BeforeEach
	void setup(TestInfo info) {
		this.info = info;
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	@DisplayName("Mostrar que cliente foi adicionado com sucesso")
	void adicionarClienteComSucesso() {
		Cliente cliente = ClienteFixture.criarCliente(info).now();
		ClienteDto clienteDTO = ClienteDTOFixture.criarClienteDTO().now();
		when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
		Response clienteAdicionado = clienteService.adicionarClientes(clienteDTO);
		
		assertTrue(Objects.nonNull(clienteAdicionado));
		assertTrue(Objects.nonNull(clienteAdicionado.getMensagem()));
		assertTrue(!"".equals(clienteAdicionado.getMensagem()));
		assertThat(clienteDTO.getNome(), equalTo(cliente.getNome()));
		assertThat(clienteDTO.getIdade(), equalTo(cliente.getIdade()));
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Mostrar que cliente foi atualizado com sucesso")
	void atualizarClienteComSucesso() {
		Cliente cliente = ClienteFixture.criarCliente(info).now();
		ClienteDto clienteDTO = ClienteDTOFixture.criarClienteDTO().now();
		when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
//		when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
		Response clienteAtualizado = clienteService.atualizarCliente(cliente.getId(), clienteDTO);
		
		assertTrue(Objects.nonNull(clienteAtualizado));
		assertTrue(Objects.nonNull(clienteAtualizado.getMensagem()));
		assertTrue(!"".equals(clienteAtualizado.getMensagem()));
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Mostrar lista de clientes que estão no Banco de Dados")
	void listarClientes() {
		List<Cliente> clienteListar = clienteService.clienteListar();
		when(clienteRepository.findAll()).thenReturn(clienteListar);
		assertTrue(Objects.nonNull(clienteListar));
		assertTrue(true);
	}
	
	@Test
	@DisplayName("Mostrar lista de clientes que estão no Banco de Dados")
	void deletarCliente() {
		Cliente cliente = ClienteFixture.criarCliente(info).comId(1L).now();
		when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
		Response clienteDeletado = clienteService.deletarCliente(cliente.getId());
		assertTrue(Objects.nonNull(clienteDeletado));
		assertTrue(Objects.nonNull(clienteDeletado.getMensagem()));
		assertTrue(!"".equals(clienteDeletado.getMensagem()));
		assertTrue(true);
	}
}
