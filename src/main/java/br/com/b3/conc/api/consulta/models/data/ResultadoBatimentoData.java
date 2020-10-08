package br.com.b3.conc.api.consulta.models.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "TCONCRESULTADO_BATIMENTO")
public class ResultadoBatimentoData {

	@Id
	@GeneratedValue
	@Column(name = "NUM_RESULTADO_BATIMENTO")
	private Long numResultadoBatimento;

    @Column(name = "DESC_RESULTADO_BATIMENTO")
    private String descResultadoBatimento;

}
