package br.com.project.rest.dto;


import br.com.project.rest.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ClienteDto {

    private String nome;

    private String idade;

    public static Cliente toCliente(ClienteDto clienteDto){
        return Cliente.builder().nome(clienteDto.nome).idade(clienteDto.idade).build();
    }




}
