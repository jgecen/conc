package br.com.b3.conc.api.consulta.models.data;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "TCONCIMPORTACAO_BOLETO")
public class ImportacaoBoletoData {
   
    @Id
    @GeneratedValue
    @Column(name = "NUM_IMPORTACAO_BOLETO")
    private Long numImportacaoBoleto;

    @Column(name = "NUM_IMPORTACAO_CONTROLE")
    private Long numImportacaoControle;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "SIGL_TIPO_TAXA") 
    private TipoOrigemEnum siglTipoTaxa;

    @Enumerated(EnumType.STRING)
    @Column(name = "NOME_TIPO_SERVICO_CONTRATO")
    private TipoServicoContratadoEnum nomeTipoServicoContrato;

    @Column(name = "NUM_CNPJ_AGENTE_FINANCEIRO")
    private String numCnpjAgenteFinanceiro;

    @Column(name = "NOME_RAZAO_SOCIAL")
    private String nomeRazaoSocial;

    @Column(name = "NUM_DOCUMENTO", unique = true) 
    private Long numDocumento;

    @Column(name = "DATA_VENCIMENTO") 
    private Date dataVencimento;

    @Column(name = "COD_LINHA_DIGITACAO")
    private String codLinhaDigitacao;

    @Column(name = "VAL_TOTAL")    
    private BigDecimal valTotal;

    @Column(name = "IND_QUANTIDADE_CONCILIACAO")
    private String indQuantidadeConciliacao;

    @Column(name = "IND_VALOR_CONCILIACAO")
    private String indValorConciliacao;


}
