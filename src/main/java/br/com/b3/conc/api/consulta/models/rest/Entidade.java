package br.com.b3.conc.api.consulta.models.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Entidade {

	@JsonProperty("nomeEntidade")
	private TipoOrigemEnum nomeEntidade;

	@JsonProperty("cnpjCode")
	private String cnpjCode;

	@JsonProperty("uf")
	private String uf;

}
