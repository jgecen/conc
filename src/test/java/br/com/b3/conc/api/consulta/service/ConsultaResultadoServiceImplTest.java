package br.com.b3.conc.api.consulta.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import br.com.b3.conc.api.consulta.models.rest.Resultado;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import lombok.extern.log4j.Log4j2;


@Log4j2 
@SpringBootTest
@ContextConfiguration
class ConsultaResultadoServiceImplTest {

	@Autowired
	ConsultaResultadoService  consultaResultadoService;
	
	@Test
	void testFindBy() {
		log.atInfo().log("Executando a consulta");
		List<Resultado> list = consultaResultadoService.findBy("09", 
				TipoServicoContratadoEnum.SISCON, "PR", null, null);
		for (Resultado resultado : list) {
			System.out.println(resultado);
		}
	}

}
