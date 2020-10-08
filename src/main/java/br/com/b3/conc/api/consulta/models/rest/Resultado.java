package br.com.b3.conc.api.consulta.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resultado {
	@JsonProperty("entidadeResponsavel")
	private Entidade entidadeResponsavel;

	@JsonProperty("dadosBoleto")
	private Boleto dadosBoleto;

	@JsonProperty("dadosOperacao")
	private Operacao dadosOperacao;

	@JsonProperty("resultadoBatimento")
	private String resultadoBatimento;
}
