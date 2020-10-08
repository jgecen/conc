package br.com.b3.conc.api.consulta.models.rest;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Operacao {

	@JsonProperty("tipoOrigemTaxa")
	private TipoOrigemEnum tipoOrigemTaxa;

	@JsonProperty("numeroContratoOperacao")
	private String numeroContratoOperacao;

	@JsonProperty("dataContratacao")
	private LocalDate dataContratacao;

	@JsonProperty("cnpjCode")
	private String cnpjCode;

	@JsonProperty("numeroChassi")
	private String numeroChassi;

	@JsonProperty("dataCadastro")
	private LocalDate dataCadastro;

	@JsonProperty("valorOperacao")
	private BigDecimal valorOperacao;

	@JsonProperty("valorFaturado")
	private BigDecimal valorFaturado;

}
