package br.com.b3.conc.api.consulta.models.data;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "TCONCCONCILIACAO_BATIMENTO")
public class ConciliacaoBatimentoData {

	@Id
	@GeneratedValue
	@Column(name = "NUM_CONCILIACAO_BATIMENTO")
	private Long numConciliacaoBatimento;

	@ManyToOne
	@JoinColumn(name = "NUM_IMPORTACAO_OPERACAO")
	private ImportacaoOperacaoData importacaoOperacaoData;

	@ManyToOne
	@JoinColumn(name = "NUM_IMPORTACAO_BOLETO")	
	private ImportacaoBoletoData importacaoBoletoData;
	
	@ManyToOne
	@JoinColumn(name = "NUM_RESULTADO_BATIMENTO")		
	private ResultadoBatimentoData resultadoBatimento;

	@Column(name = "NUM_CONCILIACAO_SOLICITACAO")
	private Long numConciliacaoSolicitacao;

	@Column(name = "COD_CADU")
	private Long codCadu;
	
	@Column(name = "COD_SUB_CADU")
	private Integer codSubCadu;
	
	@Column(name = "NOME_LOGIN_CADU")
	 private String nomeLoginCadu;
	 
	@Column(name = "DTHR_CONCILIACAO")
	 private LocalDateTime dthrConciliacao;
	
	@ManyToOne
	@JoinColumn(name="NUM_DADO_FATURAMENTO")
	private DadoFaturamento dadoFaturamento;

	
}

