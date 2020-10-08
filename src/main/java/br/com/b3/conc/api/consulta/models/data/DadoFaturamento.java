package br.com.b3.conc.api.consulta.models.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="TCONCDADO_FATURAMENTO")
public class DadoFaturamento {

	@Id
	@GeneratedValue
	@Column(name="NUM_DADO_FATURAMENTO")
	private long numDadoFaturamento;

	@Column(name="COD_CADU_AGENTE_FINANCEIRO")
	private BigDecimal codCaduAgenteFinanceiro;

	@Column(name="COD_CHASSI")
	private String codChassi;

	@Column(name="COD_TIPO_FUNCAO")
	private BigDecimal codTipoFuncao;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_OPERACAO")
	private Date dataOperacao;

	@Column(name="NUM_CNPJ_AGENTE_FINANCEIRO")
	private String numCnpjAgenteFinanceiro;

	@Column(name="NUM_MES_REFERENCIA")
	private String numMesReferencia;

	@Column(name="NUM_SEQUENCIA_CHASSI")
	private BigDecimal numSequenciaChassi;

	@Column(name="SIGL_UF_ENTIDADE")
	private String siglUfEntidade;

	@Column(name="VAL_FATURAMENTO")
	private BigDecimal valFaturamento;

}

