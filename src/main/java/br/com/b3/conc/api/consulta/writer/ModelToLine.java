package br.com.b3.conc.api.consulta.writer;

import br.com.b3.conc.api.consulta.models.rest.Boleto;
import br.com.b3.conc.api.consulta.models.rest.Operacao;
import br.com.b3.conc.api.consulta.models.rest.Resultado;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;

public class ModelToLine {

	public Line transform(Resultado resultado) {
		Line line = new Line();
		final Boleto dadosBoleto = resultado.getDadosBoleto();
		final Operacao dadosOperacao = resultado.getDadosOperacao();
		
		line.addField(0, resultado.getEntidadeResponsavel().getCnpjCode());

		if(dadosBoleto != null) {
			line.addField(1, dadosBoleto.getRazaoSocial());
			line.addField(2, dadosBoleto.getNumeroBoleto());
			line.addField(4, toString(dadosBoleto.getDataVencimento()));		
			line.addField(5, dadosBoleto.getCodigoLinhaDigitavel());
			line.addField(6, toString(dadosBoleto.getValorBoleto()));
			line.addField(13, toString(dadosBoleto.getTipoServicoContratado()));			
		} else {
			line.addField(1, null);
			line.addField(2, null);
			line.addField(4, null);		
			line.addField(5, null);
			line.addField(6, null);
			line.addField(13, null);
		}
			
		if (dadosOperacao != null) {
			line.addField(3, toString(dadosOperacao.getTipoOrigemTaxa()));	
			line.addField(7, dadosOperacao.getNumeroContratoOperacao());		
			line.addField(8, dadosOperacao.getCnpjCode());
			line.addField(9, dadosOperacao.getNumeroChassi());
			line.addField(10, toString(dadosOperacao.getDataCadastro()));	
			line.addField(11, toString(dadosOperacao.getValorOperacao()));
			line.addField(12, toString(dadosOperacao.getValorFaturado()));			
		} else {
			line.addField(3, null);	
			line.addField(7, null);		
			line.addField(8, null);
			line.addField(9, null);
			line.addField(10, null);	
			line.addField(11, null);
			line.addField(12, null);			
		}
		
		line.addField(14, resultado.getResultadoBatimento());		
		return line;
	}

	private String toString(Object val) {
		if(val != null) {
			return val.toString();
		}
		return null;
	}
}
