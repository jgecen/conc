package br.com.b3.conc.api.consulta.models.rest;

import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultaMensal {

	@JsonProperty("mesReferencia")
	private String mesReferencia;

	@JsonProperty("resultadosLista")
	@Valid
	private List<Resultado> resultadosLista;

}
