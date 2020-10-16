package br.com.b3.conc.api.consulta.models.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.b3.conc.api.consulta.HelperTest;
import br.com.b3.conc.api.consulta.models.data.ConciliacaoBatimentoData;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import br.com.b3.conc.api.consulta.repo.ConciliacaoBatimentoDataRepository;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
class ConciliacaoBatimentoDataRepositoryImplTest {

	@Autowired
	ConciliacaoBatimentoDataRepository conciliacaoBatimentoDataRepository;

	@Autowired
	DataSource dataSource;

	@BeforeEach
	void setUpt() throws Exception {
		HelperTest.initialDataset(dataSource);
	}

	@Test
	@Order(1)
	void testFindBy() {
		List<ConciliacaoBatimentoData> list = conciliacaoBatimentoDataRepository.findBy(null,
				TipoServicoContratadoEnum.SISCON, "PR", null, null);
		assertEquals(1, list.size());
	}

	@Test
	@Order(2)
	void testFindByAll() {
		List<ConciliacaoBatimentoData> list = conciliacaoBatimentoDataRepository.findBy(null, null, null, null, null);
		assertEquals(2, list.size());
	}

}
