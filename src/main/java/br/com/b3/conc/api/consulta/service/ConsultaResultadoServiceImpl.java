package br.com.b3.conc.api.consulta.service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.b3.conc.api.consulta.models.data.ConciliacaoBatimentoData;
import br.com.b3.conc.api.consulta.models.data.DadoFaturamento;
import br.com.b3.conc.api.consulta.models.data.ImportacaoBoletoData;
import br.com.b3.conc.api.consulta.models.data.ImportacaoOperacaoData;
import br.com.b3.conc.api.consulta.models.data.ResultadoBatimentoData;
import br.com.b3.conc.api.consulta.models.rest.Boleto;
import br.com.b3.conc.api.consulta.models.rest.Entidade;
import br.com.b3.conc.api.consulta.models.rest.Operacao;
import br.com.b3.conc.api.consulta.models.rest.Resultado;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import br.com.b3.conc.api.consulta.repo.ConciliacaoBatimentoDataRepository;

@Service
public class ConsultaResultadoServiceImpl implements ConsultaResultadoService {

	@Autowired
	ConciliacaoBatimentoDataRepository conciliacaoBatimentoDataRepository;

	@Override
	public List<Resultado> findBy(String mesReferencia, TipoServicoContratadoEnum tipoServicoContratado, String uf,
			TipoOrigemEnum nomeEntidade, Long identificadorResultado) {

		List<ConciliacaoBatimentoData> list = conciliacaoBatimentoDataRepository.findBy(mesReferencia,
				tipoServicoContratado, uf, nomeEntidade, identificadorResultado);
		List<Resultado> resultados = list.stream().map(batimento -> {

			DadoFaturamento dadoFaturamento = batimento.getDadoFaturamento();
			ImportacaoBoletoData importacaoBoleto = batimento.getImportacaoBoletoData();
			ImportacaoOperacaoData importacaoOperacao = batimento.getImportacaoOperacaoData();
			ResultadoBatimentoData resultadoBatimento = batimento.getResultadoBatimento();

			Resultado.ResultadoBuilder builderResultado = Resultado.builder()
					.resultadoBatimento(resultadoBatimento.getDescResultadoBatimento());
			if (importacaoBoleto != null) {
				builderResultado
					.entidadeResponsavel(Entidade.builder()
						.nomeEntidade(importacaoBoleto.getSiglTipoTaxa())
						.cnpjCode(dadoFaturamento.getNumCnpjAgenteFinanceiro())
						.uf(dadoFaturamento.getSiglUfEntidade())
						.build())
					.dadosBoleto(Boleto.builder()
							.cnpjCode(importacaoBoleto.getNumCnpjAgenteFinanceiro())
							.codigoLinhaDigitavel(importacaoBoleto.getCodLinhaDigitacao())
							.dataVencimento( importacaoBoleto.getDataVencimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
							.numeroBoleto( String.valueOf(importacaoBoleto.getNumDocumento()))
							.razaoSocial(importacaoBoleto.getNomeRazaoSocial())
							.tipoServicoContratado(importacaoBoleto.getNomeTipoServicoContrato())
							.valorBoleto(importacaoBoleto.getValTotal())
							.build());

			}
			if (importacaoOperacao != null) {
				builderResultado
					.entidadeResponsavel(Entidade.builder()
						.nomeEntidade(importacaoOperacao.getSiglTipoTaxa())
						.cnpjCode(dadoFaturamento.getNumCnpjAgenteFinanceiro())
						.uf(dadoFaturamento.getSiglUfEntidade())
						.build())
					.dadosOperacao(Operacao.builder()
							.cnpjCode(importacaoOperacao.getNumCnpjAgenteFinanceiro())
							.dataCadastro(importacaoOperacao.getDataCadastro().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
							.dataContratacao(importacaoOperacao.getDataContrato().toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
							.numeroChassi(importacaoOperacao.getCodChassi())
							.numeroContratoOperacao(importacaoOperacao.getCodContrato())
							.tipoOrigemTaxa(importacaoOperacao.getSiglTipoTaxa())
							.valorFaturado(dadoFaturamento.getValFaturamento())
							.valorOperacao(new BigDecimal("0"))
							.build());

			}

			return builderResultado.build();
		}).collect(Collectors.toList());

		return resultados;
	}
}
