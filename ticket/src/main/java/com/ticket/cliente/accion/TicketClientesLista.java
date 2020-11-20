package com.ticket.cliente.accion;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ticket.cliente.entidades.TicketCliente;
import com.ticket.cliente.servicios.ServicioTicketCliente;

@Named("ticketClientesLista")
@ViewScoped
public class TicketClientesLista implements Serializable {

	private List<TicketCliente> ticketClientesList;
	private List<TicketCliente> ticketClientesFiltros;
	private ServicioTicketCliente servicioTicketCliente;
	
	private TicketCliente idTicket;
	
	@PostConstruct
	public void init() {
		servicioTicketCliente = new ServicioTicketCliente();
		ticketClientesList = servicioTicketCliente.lista();
	}

	public List<TicketCliente> getTicketClientesList() {
		return ticketClientesList;
	}

	public void setTicketClientesList(List<TicketCliente> ticketClientesList) {
		this.ticketClientesList = ticketClientesList;
	}

	public List<TicketCliente> getTicketClientesFiltros() {
		return ticketClientesFiltros;
	}

	public void setTicketClientesFiltros(List<TicketCliente> ticketClientesFiltros) {
		this.ticketClientesFiltros = ticketClientesFiltros;
	}

	public TicketCliente getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(TicketCliente idTicket) {
		this.idTicket = idTicket;
	}
	
}
