package br.com.b3.conc.api.consulta.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConciliacaoConsultaResultadosRspGet {

	@JsonProperty("Periodo")
	private ConsultaMensal periodo;

}
