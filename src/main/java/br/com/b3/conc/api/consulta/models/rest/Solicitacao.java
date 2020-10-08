package br.com.b3.conc.api.consulta.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Solicitacao {
	@JsonProperty("identificadorSolicitacao")
	private Long identificadorSolicitacao;

	@JsonProperty("mesReferencia")
	private String mesReferencia;

	@JsonProperty("tipoSituacaoSolicitacao")
	private String tipoSituacaoSolicitacao;

	@JsonProperty("tipoSolicitacao")
	private String tipoSolicitacao;

	@JsonProperty("indicadorSolicitacaoAtiva")
	private String indicadorSolicitacaoAtiva;

	@JsonProperty("identificacaoUsuario")
	private Usuario identificacaoUsuario;

}
