package br.com.project.rest.dto;


import br.com.project.rest.model.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClienteDto {

    private String nome;

    private String idade;

    public static Cliente toCliente(ClienteDto clienteDto){
        return Cliente.builder().nome(clienteDto.nome).idade(clienteDto.idade).build();
    }




}
