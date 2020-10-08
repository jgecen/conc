package br.com.b3.conc.api.consulta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.b3.conc.api.consulta.models.rest.ConciliacaoConsultaResultadosRspGet;
import br.com.b3.conc.api.consulta.models.rest.ConsultaMensal;
import br.com.b3.conc.api.consulta.models.rest.Resultado;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoOrigemEnum;
import br.com.b3.conc.api.consulta.models.shared.enums.TipoServicoContratadoEnum;
import br.com.b3.conc.api.consulta.service.ConsultaResultadoService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/v1/solicitacoes/resultados")
public class ConsultaResultadoController {

	@Autowired
	ConsultaResultadoService consultaResultadoService;

	@GetMapping
	ResponseEntity<ConciliacaoConsultaResultadosRspGet> resultadosGet(
			@RequestParam(required = false)
			String mesReferencia,
			
			@RequestParam(required = false)
			String tipoServicoContratado,
			
			@RequestParam(required = false)
			String uf,
			
			@RequestParam(required = false)
			String nomeEntidade,
			
			@RequestParam(required = false)
			Long identificadorResultado) {
		
	
		
		List<Resultado> resultados = consultaResultadoService.findBy(mesReferencia,
				TipoServicoContratadoEnum.from(tipoServicoContratado), uf, TipoOrigemEnum.from(nomeEntidade),
				identificadorResultado);
		if(resultados != null) {
			ConciliacaoConsultaResultadosRspGet resultadosRspGet = ConciliacaoConsultaResultadosRspGet.builder()
					.periodo(ConsultaMensal.builder().mesReferencia(mesReferencia).resultadosLista(resultados).build())
					.build();

			return new ResponseEntity<ConciliacaoConsultaResultadosRspGet>(resultadosRspGet, HttpStatus.OK);
			
		}
		return (ResponseEntity<ConciliacaoConsultaResultadosRspGet>) ResponseEntity.noContent();

	}
}
