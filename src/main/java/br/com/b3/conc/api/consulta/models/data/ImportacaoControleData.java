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
@Table(schema = "CONC", name = "TCONCIMPORTACAO_CONTROLE")
public class ImportacaoControleData {

    @Id
    @GeneratedValue
    @Column(name = "NUM_IMPORTACAO_CONTROLE")
    private Long numImportacaoControle;

    @Enumerated(EnumType.STRING)
    @Column(name = "SIGL_TIPO_ENTIDADE")
    private TipoOrigemEnum siglTipoEntidade;

    @Column(name = "NUM_CNPJ_ENTIDADE")
    private	String numCnpjEntidade;

    @Column(name = "SIGL_UF_ENTIDADE")
    private String siglUfEntidade;

    @Column(name = "COD_CADU")
    private Long codCadu;

    @Column(name = "COD_SUB_CADU")
    private Integer codSubCadu;

    @Column(name = "NOME_LOGIN_CADU")
    private String nomeLoginCadu;

    @Column(name = "NUM_MES_REFERENCIA")
    private String numMesReferencia;

    @Column(name = "DATA_IMPORTACAO")
    private Date dataImportacao;
}

