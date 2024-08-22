package br.com.project.rest.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.project.rest.dto.ClienteDto;
import br.com.project.rest.model.Cliente;

@DataJpaTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {
	
	private static final String IDADE = "21";
	private static final String NAME = "Victor";
	
	private static final String NEW_IDADE = "17";
	private static final String NEW_NAME = "Leonardo";
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Test
	@DisplayName("Mostrar cliente salvo no banco")
	void adicionarCliente1() {
		Cliente saveCliente = saveClienteNew();
		assertTrue(Objects.nonNull(saveCliente));
		assertThat(saveCliente);
		assertTrue(true);
	}

	@Test
	@DisplayName("Mostrar cliente update no banco")
	void atualizarCliente2() {
		Cliente saveCliente = saveClienteNew();
		Cliente saveCliente2 = updateClienteAntigo(saveCliente);
		assertTrue(Objects.nonNull(saveCliente2));
		assertThat(saveCliente2);
		assertTrue(true);
	}

	@Test
	@DisplayName("Mostrar cliente deletado no banco")
	void deletarCliente43() {
		Cliente saveCliente = saveClienteNew();
		clienteRepository.delete(saveCliente);
		assertThat(clienteRepository.findById(saveCliente.getId())).isEmpty();
	}
	
	private Cliente createCliente(ClienteDto clienteDto) {
		Cliente cliente = ClienteDto.toCliente(clienteDto);
		return cliente;
	}
	
	private Cliente saveClienteNew() {
		ClienteDto cliente = ClienteDto.builder().nome(NAME).idade(IDADE).build();
		this.createCliente(cliente);
		Cliente newCliente = Cliente.builder().id(1L).nome(cliente.getNome()).idade(cliente.getIdade()).build();
		Cliente saveCliente = this.clienteRepository.save(newCliente);
		return saveCliente;
	}
	
	private Cliente updateClienteAntigo(Cliente saveCliente) {
		ClienteDto clienteDto = ClienteDto.builder().nome(NEW_NAME).idade(NEW_IDADE).build();
		Cliente newCliente2 = this.updateClienteFindByIdClienteAntigo(saveCliente.getId(), clienteDto);
		Cliente saveCliente2 = this.clienteRepository.save(newCliente2);
		return saveCliente2;
	}
	
	private Cliente updateClienteFindByIdClienteAntigo(Long idCliente, ClienteDto clienteDto) {
		Cliente clienteAntigo = this.clienteRepository.findById(idCliente).get();
		Cliente newCliente = Cliente.builder()
									.id(clienteAntigo.getId())
									.nome(Objects.nonNull(clienteDto.getNome()) ? clienteDto.getNome() : clienteAntigo.getNome())
									.idade(Objects.nonNull(clienteDto.getIdade()) ? clienteDto.getIdade() : clienteAntigo.getIdade())
									.build();
		return newCliente;
	}
}
