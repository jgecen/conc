package br.com.b3.conc.api.consulta.writer;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.b3.conc.api.consulta.models.rest.Boleto;
import br.com.b3.conc.api.consulta.models.rest.Entidade;
import br.com.b3.conc.api.consulta.models.rest.Operacao;
import br.com.b3.conc.api.consulta.models.rest.Resultado;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;

class ModelToLineTest {

	private Resultado resultado;

	@BeforeEach
	void setUp() throws Exception {
		
		Boleto dadosBoleto = createBoleto();

		Operacao dadosOperacao = createOperacao();		
		
		Entidade entidadeResponsavel = Entidade.builder()
				.cnpjCode("001234560000101")				
				.build();
		
		resultado = Resultado.builder()
				.resultadoBatimento("RESULTADO_OK")
				.dadosBoleto(dadosBoleto)
				.dadosOperacao(dadosOperacao)
				.entidadeResponsavel(entidadeResponsavel)
				.build();
		
	}

	private Operacao createOperacao() {
		return Operacao.builder()
				.tipoOrigemTaxa(TipoOrigemEnum.ERC)
				.numeroContratoOperacao("999888")
				.cnpjCode("121234560001")
				.numeroChassi("AP01XX663")
				.dataCadastro(LocalDate.of(2020, 5, 25))
				.valorOperacao(new BigDecimal("1000.00"))
				.valorFaturado(new BigDecimal("900.00"))
				.build();

	}

	private Boleto createBoleto() {
		return  Boleto.builder()
				.razaoSocial("RAZAO SOCIAL")
				.numeroBoleto("10")
				.dataVencimento(LocalDate.of(2020, 9, 15))
				.codigoLinhaDigitavel("101010")
				.valorBoleto(new BigDecimal("100.00"))
				.tipoServicoContratado(TipoServicoContratadoEnum.SISCON)
				.build();
	}

	@Test
	void testTransform() {
		ModelToLine to = new ModelToLine();
		Line line = to.transform(resultado);
		String string = line.toString();
		assertEquals("001234560000101;RAZAO SOCIAL;10;ERC;2020-09-15;101010;100.00;999888;121234560001;AP01XX663;2020-05-25;1000.00;900.00;SISCON;RESULTADO_OK", string);
		
	}
	
	@Test
	void testTransformBoletoNull() {
		Operacao operacao = createOperacao();
		
		ModelToLine to = new ModelToLine();		
		Resultado resultado = Resultado.builder()
				.resultadoBatimento(null)
				.dadosBoleto(null)
				.dadosOperacao(operacao)
				.entidadeResponsavel( Entidade.builder().build() )
				.build();
				
		Line line = to.transform(resultado);
		String string = line.toString();
		assertEquals("--;--;--;ERC;--;--;--;999888;121234560001;AP01XX663;2020-05-25;1000.00;900.00;--;--", string);		
	}
	
	@Test
	void testTransformOperacaoNull() {
		Boleto dadosBoleto = createBoleto();

		ModelToLine to = new ModelToLine();
		Resultado resultado = Resultado.builder()
				.resultadoBatimento(null)
				.dadosBoleto(dadosBoleto)
				.dadosOperacao(Operacao.builder().build())
				.entidadeResponsavel( Entidade.builder().build() )
				.build();
				
		Line line = to.transform(resultado);
		String string = line.toString();
		assertEquals("--;RAZAO SOCIAL;10;--;2020-09-15;101010;100.00;--;--;--;--;--;--;SISCON;--", string);
		
	}

}
