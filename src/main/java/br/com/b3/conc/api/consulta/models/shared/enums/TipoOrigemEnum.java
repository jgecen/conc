package br.com.b3.conc.api.consulta.models.shared.enums;

import java.util.stream.Stream;

import lombok.Getter;

@Getter
public enum TipoOrigemEnum {

	ERC("ERC"), DETRAN("DETRAN");

	private String codigo;

	TipoOrigemEnum(String codigo) {
		this.codigo = codigo;
	}

	public static TipoOrigemEnum from(String codigo) {
		if (codigo == null)
			return null;
		return Stream.of(values()).filter(t -> t.codigo.equals(codigo)).findFirst().orElse(null);
	}
}
