package br.com.b3.conc.api.consulta.service;

import java.util.List;

import br.com.b3.conc.api.consulta.models.rest.Resultado;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;

public interface ConsultaResultadoService {

	List<Resultado> findBy(String mesReferencia, TipoServicoContratadoEnum tipoServicoContratado, String uf,
			TipoOrigemEnum nomeEntidade, Long identificadorResultado);

}