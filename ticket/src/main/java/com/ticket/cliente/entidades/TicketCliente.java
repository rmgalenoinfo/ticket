package com.ticket.cliente.entidades;
// Generated 20 nov. 2020 13:39:36 by Hibernate Tools 5.4.12.Final

import java.util.Date;

/**
 * TicketCliente generated by hbm2java
 */
public class TicketCliente implements java.io.Serializable {

	private int idTicket;
	private Cliente cliente;
	private Estados estados;
	private Prioridades prioridades;
	private String ticket;
	private String clienteCaso;
	private Date fechaVencimiento;
	private String acuerdo;

	public TicketCliente() {
	}

	public TicketCliente(int idTicket, Cliente cliente, Estados estados, String ticket) {
		this.idTicket = idTicket;
		this.cliente = cliente;
		this.estados = estados;
		this.ticket = ticket;
	}

	public TicketCliente(int idTicket, Cliente cliente, Estados estados, Prioridades prioridades, String ticket,
			String clienteCaso, Date fechaVencimiento, String acuerdo) {
		this.idTicket = idTicket;
		this.cliente = cliente;
		this.estados = estados;
		this.prioridades = prioridades;
		this.ticket = ticket;
		this.clienteCaso = clienteCaso;
		this.fechaVencimiento = fechaVencimiento;
		this.acuerdo = acuerdo;
	}

	public int getIdTicket() {
		return this.idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estados getEstados() {
		return this.estados;
	}

	public void setEstados(Estados estados) {
		this.estados = estados;
	}

	public Prioridades getPrioridades() {
		return this.prioridades;
	}

	public void setPrioridades(Prioridades prioridades) {
		this.prioridades = prioridades;
	}

	public String getTicket() {
		return this.ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public String getClienteCaso() {
		return this.clienteCaso;
	}

	public void setClienteCaso(String clienteCaso) {
		this.clienteCaso = clienteCaso;
	}

	public Date getFechaVencimiento() {
		return this.fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getAcuerdo() {
		return this.acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}

}