package br.com.b3.conc.api.consulta.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Usuario {
	@JsonProperty("codigoUsuario")
	private Long codigoUsuario;

	@JsonProperty("subCodigoUsuario")
	private Integer subCodigoUsuario;

	@JsonProperty("loginUsuario")
	private String loginUsuario;

}
