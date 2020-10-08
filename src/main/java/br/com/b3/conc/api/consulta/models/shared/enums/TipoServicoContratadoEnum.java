package br.com.b3.conc.api.consulta.models.shared.enums;

import lombok.Getter;
import java.util.stream.Stream;

@Getter
public enum TipoServicoContratadoEnum {

	SISCON("SISCON", "Sistema de Contratos"), INTEGRA_MAIS_SOLUCAO("INTEGRA_MAIS_SOLUCAO", "Integra + Solução");

	private final String codigo;
	private final String descricao;

	TipoServicoContratadoEnum(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public static TipoServicoContratadoEnum from(String codigo) {
		if (codigo == null)
			return null;
		return Stream.of(values()).filter(i -> i.getCodigo().equals(codigo)).findFirst().orElse(null);
	}

}
