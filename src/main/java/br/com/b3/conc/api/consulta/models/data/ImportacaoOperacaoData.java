package br.com.b3.conc.api.consulta.models.data;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
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
@Table(name = "TCONCIMPORTACAO_OPERACAO")
public class ImportacaoOperacaoData {
    
    @Id
    @GeneratedValue
    @Column(name = "NUM_IMPORTACAO_OPERACAO")
    private Long numImportacaoOperacao;

    @Column(name = "NUM_IMPORTACAO_CONTROLE")
    private Long numImportacaoControle;

    @Enumerated(EnumType.STRING)
    @Column(name = "SIGL_TIPO_TAXA")
    private TipoOrigemEnum siglTipoTaxa;

    @Column(name = "COD_CONTRATO")
    private String codContrato;

    @Column(name = "DATA_CONTRATO")
    private Date dataContrato;

    @Column(name = "DATA_CADASTRO")
    private Date dataCadastro;

    @Column(name = "NUM_CNPJ_AGENTE_FINANCEIRO")
    private String numCnpjAgenteFinanceiro;

    @Column(name = "COD_CHASSI")
    private String codChassi;


}
