package br.com.b3.conc.api.consulta.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;




@ToString
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
