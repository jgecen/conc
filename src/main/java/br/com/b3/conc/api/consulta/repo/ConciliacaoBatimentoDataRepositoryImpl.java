package br.com.b3.conc.api.consulta.repo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.b3.conc.api.consulta.models.data.ConciliacaoBatimentoData;
import br.com.b3.conc.api.consulta.models.data.DadoFaturamento;
import br.com.b3.conc.api.consulta.models.data.ImportacaoBoletoData;
import br.com.b3.conc.api.consulta.models.data.ImportacaoOperacaoData;
import br.com.b3.conc.api.consulta.models.data.ResultadoBatimentoData;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;

@Repository
public class ConciliacaoBatimentoDataRepositoryImpl implements ConciliacaoBatimentoDataRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<ConciliacaoBatimentoData> findBy(
			String mesReferencia,
			TipoServicoContratadoEnum tipoServicoContratado,
			String uf,
			TipoOrigemEnum nomeEntidade, 
			Long identificadorResultado) {
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<ConciliacaoBatimentoData> criteriaQuery = criteriaBuilder
				.createQuery(ConciliacaoBatimentoData.class);
		Root<ConciliacaoBatimentoData> rootBatimento = criteriaQuery.from(ConciliacaoBatimentoData.class);
		Join<ConciliacaoBatimentoData, ImportacaoOperacaoData> joinBatimentoOperacao = rootBatimento
				.join("importacaoOperacaoData", JoinType.LEFT);
		Join<ConciliacaoBatimentoData, ImportacaoBoletoData> joinBatimentoBoleto = rootBatimento
				.join("importacaoBoletoData", JoinType.LEFT);
		Join<ConciliacaoBatimentoData, ResultadoBatimentoData> joinBatimentoResultado = rootBatimento
				.join("resultadoBatimento", JoinType.INNER);
		Join<ConciliacaoBatimentoData, DadoFaturamento> joinBatimentoFaturamento = rootBatimento.join("dadoFaturamento",
				JoinType.INNER);

		List<Predicate> restricoes = new ArrayList<>();

		if(mesReferencia != null) {
			restricoes.add(criteriaBuilder.equal(joinBatimentoFaturamento.get("numMesReferencia"), mesReferencia));	
		}
		
		if(tipoServicoContratado != null) {
			restricoes.add(criteriaBuilder.equal(joinBatimentoBoleto.get("nomeTipoServicoContrato"), tipoServicoContratado));
		}
		
		if(uf != null) {
			restricoes.add(criteriaBuilder.equal(joinBatimentoFaturamento.get("siglUfEntidade"), uf));	
		}		

		if (nomeEntidade != null) {
			restricoes.add(criteriaBuilder.equal(joinBatimentoOperacao.get("siglTipoTaxa"), nomeEntidade));
			restricoes.add(criteriaBuilder.equal(joinBatimentoBoleto.get("siglTipoTaxa"), nomeEntidade));
		}

		if (identificadorResultado != null) {
			restricoes.add(criteriaBuilder.equal(joinBatimentoResultado.get("numResultadoBatimento"), identificadorResultado));
		}

		criteriaQuery.where(restricoes.toArray(new Predicate[] {}));

		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
