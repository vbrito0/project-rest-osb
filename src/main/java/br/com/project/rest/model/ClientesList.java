package br.com.project.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ClientesList {
	
	@JsonProperty("Cliente")
	private List<Cliente> cliente;
}
