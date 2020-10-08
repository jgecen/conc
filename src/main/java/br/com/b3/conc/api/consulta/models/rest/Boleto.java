package br.com.b3.conc.api.consulta.models.rest;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Boleto   {
	
  @JsonProperty("tipoServicoContratado")
  private TipoServicoContratadoEnum tipoServicoContratado;

  @JsonProperty("cnpjCode")
  private String cnpjCode;

  @JsonProperty("razaoSocial")
  private String razaoSocial;

  @JsonProperty("numeroBoleto")
  private String numeroBoleto;

  @JsonProperty("dataVencimento")
  private LocalDate dataVencimento;

  @JsonProperty("codigoLinhaDigitavel")
  private String codigoLinhaDigitavel;

  @JsonProperty("valorBoleto")
  private BigDecimal valorBoleto;
}

