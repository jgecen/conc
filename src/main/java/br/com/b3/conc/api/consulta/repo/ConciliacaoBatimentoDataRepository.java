package br.com.b3.conc.api.consulta.repo;

import java.util.List;

import br.com.b3.conc.api.consulta.models.data.ConciliacaoBatimentoData;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;

public interface ConciliacaoBatimentoDataRepository {

	List<ConciliacaoBatimentoData> findBy(
			String mesReferencia,
			TipoServicoContratadoEnum tipoServicoContratado,
			String uf,
			TipoOrigemEnum nomeEntidade, 
			Long identificadorResultado);
}


