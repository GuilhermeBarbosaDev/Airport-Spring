package com.airport.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.airport.domain.Cliente;
import com.airport.domain.Tecnico;
import com.airport.domain.Ticket;
import com.airport.domain.enums.Perfil;
import com.airport.domain.enums.Prioridade;
import com.airport.domain.enums.Status;
import com.airport.repository.PessoaRepository;
import com.airport.repository.TicketRepository;

@Service
public class DBService {

		// Fazer com que o Spring adicione os dados do método run automaticamente no BD H2:
		@Autowired
		private PessoaRepository pessoaRepository;
		@Autowired
		private TicketRepository ticketRepository;
		
		//Para criptografar a senha
		@Autowired
		private BCryptPasswordEncoder encoder;
		
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Guilherme Barbosa", "596.524.270-04", "guilhermebarbosajob@gmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"));
		Tecnico tec6 = new Tecnico(null, "Teste Teste", "863.752.835-07", "teste@mail.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));
		Cliente cli6 = new Cliente(null, "Visitante", "482.399.920-72", "visitante@teste.com", encoder.encode("visitante746521"));
		
		
		Ticket c1 = new Ticket(null, Prioridade.MEDIA, Status.ANDAMENTO, "ticket 1", "Teste ticket 1", tec1, cli1);
		Ticket c2 = new Ticket(null, Prioridade.ALTA, Status.ABERTO, "ticket 2", "Teste ticket 2", tec1, cli2);
		Ticket c3 = new Ticket(null, Prioridade.BAIXA, Status.ENCERRADO, "ticket 3", "Teste ticket 3", tec2, cli3);
		Ticket c4 = new Ticket(null, Prioridade.ALTA, Status.ABERTO, "ticket 4", "Teste ticket 4", tec3, cli3);
		Ticket c5 = new Ticket(null, Prioridade.MEDIA, Status.ANDAMENTO, "ticket 5", "Teste ticket 5", tec2, cli1);
		Ticket c6 = new Ticket(null, Prioridade.BAIXA, Status.ENCERRADO, "ticket 7", "Teste ticket 6", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5,tec6, cli1, cli2, cli3, cli4, cli5, cli6));
		ticketRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));

	}
}
