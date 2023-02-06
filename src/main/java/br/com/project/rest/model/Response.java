package br.com.project.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response {
	
	public String mensagem;

	public void setMessage(String mensagem) {
		this.mensagem = mensagem;
	}
}
