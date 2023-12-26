package br.com.project.rest.fixture;

import org.junit.jupiter.api.TestInfo;

import br.com.project.rest.model.Cliente;

public class ClienteFixture {
	
	private static final Long ID = 1L;
	private static final String NOME = "Victor";
	private static final String IDADE = "21";
	
	private static Cliente cliente;
	
	public static ClienteFixture criarCliente(TestInfo info) {
		cliente = Cliente.builder()
						 .id(ID)
						 .nome(NOME)
						 .idade(IDADE)
						 .build();
	return new ClienteFixture();
	}
	
	public ClienteFixture comId(Long id) {
		cliente.setId(id);
		return this;
	}
	
	public ClienteFixture comNome(String nome) {
		cliente.setNome(nome);
		return this;
	}
	
	public ClienteFixture comIdade(String idade) {
		cliente.setIdade(idade);
		return this;
	}
	
	public Cliente now() {
		return cliente;
	}
}
