package com.ticket.cliente.accion;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ticket.cliente.entidades.Cliente;
import com.ticket.cliente.entidades.Estados;
import com.ticket.cliente.entidades.Prioridades;
import com.ticket.cliente.entidades.TicketCliente;
import com.ticket.cliente.servicios.ServicioTicketCliente;

@Named
@ViewScoped
public class TicketClientesAccion implements Serializable{

	private int idTicketCliente;
	private int idCliente;
	private int idEstado;
	private int idPrioridad;
	private String ticket;
	private Date fechaLimite;
	private String acuerdo;
	
	public void grabar() {
		TicketCliente ticketCliente = new TicketCliente();
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		Estados estados = new Estados();
		estados.setIdEstado(idEstado);
		Prioridades prioridades = new Prioridades();
		prioridades.setIdPrioridad(idPrioridad);
		ServicioTicketCliente servicioTicketCliente = new ServicioTicketCliente();
		servicioTicketCliente.guardar(ticketCliente);
		
	}
	
	public void buscarTocken(int idTockenCliente) {
		TicketCliente ticketCliente = new TicketCliente();
		ServicioTicketCliente servicioTicketCliente = new ServicioTicketCliente();
		ticketCliente = servicioTicketCliente.buscarId(idTockenCliente);
		idCliente = ticketCliente.getCliente().getIdCliente();
		idEstado = ticketCliente.getEstados().getIdEstado();
		idPrioridad = ticketCliente.getPrioridades().getIdPrioridad();
		ticket = ticketCliente.getTicket();
		fechaLimite = ticketCliente.getFechaVencimiento();
		acuerdo = ticketCliente.getAcuerdo();
	}

	public int getIdTicketCliente() {
		return idTicketCliente;
	}

	public void setIdTicketCliente(int idTicketCliente) {
		this.idTicketCliente = idTicketCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public int getIdPrioridad() {
		return idPrioridad;
	}

	public void setIdPrioridad(int idPrioridad) {
		this.idPrioridad = idPrioridad;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}
	
	

}
