package br.com.project.rest.fixture;

import br.com.project.rest.dto.ClienteDto;

public class ClienteDTOFixture {
	
	private static final String NOME = "Victor";
	private static final String IDADE = "21";
	
	private static ClienteDto clienteDto;
	
	public static ClienteDTOFixture criarClienteDTO() {
		clienteDto = ClienteDto.builder()
								.nome(NOME)
								.idade(IDADE)
								.build();
	return new ClienteDTOFixture();
								
	}
	
	public ClienteDTOFixture comNome(String nome) {
		clienteDto.setNome(nome);
		return this;
	}
	
	public ClienteDTOFixture comIdade(String idade) {
		clienteDto.setIdade(idade);
		return this;
	}
	
	public ClienteDto now() {
		return clienteDto;
	}
}
