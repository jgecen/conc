package br.com.b3.conc.api.consulta.models.repo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import br.com.b3.conc.api.consulta.models.data.ConciliacaoBatimentoData;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import br.com.b3.conc.api.consulta.repo.ConciliacaoBatimentoDataRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2 
@SpringBootTest
@ContextConfiguration
class ConciliacaoBatimentoDataRepositoryImplTest {

	@Autowired
	ConciliacaoBatimentoDataRepository conciliacaoBatimentoDataRepository;
	
	@Test
	void testFindBy() {
		log.info("Executando teste");
		List<ConciliacaoBatimentoData> list = conciliacaoBatimentoDataRepository.findBy("09", 
				TipoServicoContratadoEnum.SISCON, "PR", null, null);
		for (ConciliacaoBatimentoData conciliacaoBatimentoData : list) {
			System.out.println(conciliacaoBatimentoData);
		}
	}

}
