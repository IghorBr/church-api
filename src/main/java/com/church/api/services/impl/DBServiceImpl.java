package com.church.api.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.church.api.entities.Congregacao;
import com.church.api.entities.Endereco;
import com.church.api.entities.Evento;
import com.church.api.entities.Igreja;
import com.church.api.entities.Pastor;
import com.church.api.entities.Recorrencia;
import com.church.api.entities.Usuario;
import com.church.api.entities.enums.DiaSemana;
import com.church.api.entities.enums.TipoRecorrencia;
import com.church.api.entities.enums.TipoUsuario;
import com.church.api.services.EventoService;
import com.church.api.services.PastorService;
import com.church.api.services.TemploService;
import com.church.api.services.UsuarioService;

@Service
@Transactional
public class DBServiceImpl {

	@Autowired private UsuarioService usuarioService;
	@Autowired private PastorService pastorService;
	@Autowired private TemploService temploService;
	@Autowired private EventoService eventoService;
	
	public void instantiateTestDatabase() throws ParseException {
		Usuario user1 = new Usuario(null, "Ighor", "Brito", "ighorbruno20@gmail.com", "123", TipoUsuario.MEMBRO);
		Usuario user2 = new Usuario(null, "Admin", "", "admin@gmail.com", "123", TipoUsuario.ADMIN);
		Usuario user3 = new Usuario(null, "Guest", "", "guest@gmail.com", "123", TipoUsuario.CONVIDADO);
		
		this.usuarioService.saveAll(Arrays.asList(user1, user2, user3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Pastor p1 = new Pastor(null, "Amarildo", "Rangel", sdf.parse("30/03/2020"), null);
		Pastor p2 = new Pastor(null, "Roberto", "Sarmento", sdf.parse("30/05/2016"), sdf.parse("30/06/2019"));
		
		this.pastorService.saveAll(Arrays.asList(p1, p2));
		
		Endereco end1 = new Endereco(null, "Estrada Santa Perciliana", "RJ", 
				"Nova Iguaçu", "26052-790", "3048", null);
		
		Igreja pib = new Igreja(null, "Primeira Igreja Batista em Nova Brasília", "PIBNB", 
				sdf.parse("27/12/1970"), "(21) 3759-0551", end1, "Não sei o cnpj da igreja");
		
		end1.setTemplo(pib);
		user1.addTemplo(pib);
		
		pib.setPastorPresidente(p1);
		p1.setIgreja(pib);
		
		temploService.save(pib);
		usuarioService.saveAll(Arrays.asList(user1));
		this.pastorService.save(p1);
		
		Endereco end2 = new Endereco(null, "Rua das Marrecas", "RJ", "Nova Iguaçu", "Não sei", "Tmb não sei", null);
		Congregacao cng = new Congregacao(null, "Congregação em Vila Ômega", "Congregação", sdf.parse("20/05/2007"), null, end2, pib);
		
		end2.setTemplo(cng);
		user2.addTemplo(cng);
		pib.addCongregacao(cng);
		
		temploService.save(cng);
		usuarioService.saveAll(Arrays.asList(user2));
		
		temploService.save(pib);
		
		Recorrencia recOracaoDomingo = new Recorrencia(null, DiaSemana.DOMINGO, 
				TipoRecorrencia.ANUAL, "08:00h", 1, null);
		
		Recorrencia recEBDDomingo = new Recorrencia(null, DiaSemana.DOMINGO, 
				TipoRecorrencia.ANUAL, "10:30h", 1, null);
		
		Recorrencia recAdoracaoDomingo = new Recorrencia(null, DiaSemana.DOMINGO, 
				TipoRecorrencia.ANUAL, "18:00h", 1,null);
		
		Recorrencia recOracaoTerca = new Recorrencia(null, DiaSemana.TERCA, 
				TipoRecorrencia.ANUAL, "08:00h", 1, null);
		
		Recorrencia recOracaoQuinta = new Recorrencia(null, DiaSemana.QUINTA, 
				TipoRecorrencia.ANUAL, "19:00h", 1, null);
		
		Recorrencia recCultoSegunda = new Recorrencia(null, DiaSemana.SEGUNDA, 
				TipoRecorrencia.ANUAL, "19:30h", 1, null);
		
		Recorrencia recCultoSabado = new Recorrencia(null, DiaSemana.SABADO, 
				TipoRecorrencia.ANUAL, "07:00h", 1, null);
		
		
		SimpleDateFormat dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Evento oracaoDomingo = new Evento(null, "Culto de Oração", null, recOracaoDomingo, pib);
		Evento domingoManha = new Evento(null, "EBD", null, recEBDDomingo, pib);
		Evento domingoNoite = new Evento(null, "Culto de Adoração",null, recAdoracaoDomingo, pib);
		Evento oracaoTerca = new Evento(null, "Culto de Oração", null, recOracaoTerca, pib);
		Evento oracaoQuinta = new Evento(null, "Culto de Oração e Doutrina", null, recOracaoQuinta, pib);
		
		Evento cultoSegunda = new Evento(null, "Culto", null, recCultoSegunda, cng);
		Evento sabadoOracao = new Evento(null, "Culto Matutino", null, recCultoSabado, cng);
		
		pib.addEvento(oracaoDomingo, domingoManha, domingoNoite, oracaoTerca, oracaoQuinta);
		cng.addEvento(cultoSegunda, sabadoOracao);
		
		temploService.saveAll(Arrays.asList(pib, cng));
		eventoService.saveAll(Arrays.asList(oracaoDomingo, domingoManha, domingoNoite, oracaoTerca, oracaoQuinta, cultoSegunda, sabadoOracao));
		
		Evento cultoAcaoGracas = new Evento(null, "Culto de Ação de Gracas", dataHora.parse("29/01/2022 19:00"), null, pib);
		pib.addEvento(cultoAcaoGracas);
		temploService.saveAll(Arrays.asList(pib));
		eventoService.save(cultoAcaoGracas);
	}
	
}
