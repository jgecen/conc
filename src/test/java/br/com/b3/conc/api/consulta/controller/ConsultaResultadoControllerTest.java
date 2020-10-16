package br.com.b3.conc.api.consulta.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;

import javax.sql.DataSource;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.b3.conc.api.consulta.HelperTest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
class ConsultaResultadoControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	DataSource dataSource;

	@BeforeEach
	void setUpt() throws Exception {
		HelperTest.initialDataset(dataSource);
	}

	@Test
	@Order(1)
	void testContextLoad() {
		assertThat(restTemplate).isNotNull();
		assertThat(dataSource).isNotNull();
	}

	@Test
	@Order(2)
	void testResultadosGet() {
		String resource = String.format("http://localhost:%d/v1/solicitacoes/resultados?mesReferencia=%s", port, "09");
		String string = restTemplate.getForObject(resource, String.class);
		String esperado = "{\"Periodo\":{\"mesReferencia\":\"09\",\"resultadosLista\":[{\"entidadeResponsavel\":{\"nomeEntidade\":\"ERC\",\"cnpjCode\":\"88463999924\",\"uf\":\"PR\"},\"dadosBoleto\":null,\"dadosOperacao\":{\"tipoOrigemTaxa\":\"ERC\",\"numeroContratoOperacao\":\"101\",\"dataContratacao\":\"2000-10-10\",\"cnpjCode\":\"88463999924\",\"numeroChassi\":\"CHASSI01\",\"dataCadastro\":\"2000-10-10\",\"valorOperacao\":0,\"valorFaturado\":1000.00},\"resultadoBatimento\":\"OOoooooooooooooopsssssssssss\"},{\"entidadeResponsavel\":{\"nomeEntidade\":\"ERC\",\"cnpjCode\":\"88463999924\",\"uf\":\"PR\"},\"dadosBoleto\":{\"tipoServicoContratado\":\"SISCON\",\"cnpjCode\":\"99463999924\",\"razaoSocial\":\"RAZAO SOCIAL\",\"numeroBoleto\":\"10\",\"dataVencimento\":\"2020-09-25\",\"codigoLinhaDigitavel\":\"1\",\"valorBoleto\":1000.00},\"dadosOperacao\":null,\"resultadoBatimento\":\"NNNNNNNNNNNNNnnnnnnnnnn\"}]}}";
		assertThat(string).isEqualTo(esperado);
	}

}
