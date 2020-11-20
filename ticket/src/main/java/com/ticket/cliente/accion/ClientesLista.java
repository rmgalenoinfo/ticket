package com.ticket.cliente.accion;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ticket.cliente.entidades.Cliente;
import com.ticket.cliente.servicios.ServicioCliente;

@Named
@ViewScoped
public class ClientesLista implements Serializable{

	private List<Cliente> clienteList;
	private ServicioCliente servicioCliente;
	
	@PostConstruct
	public void init() {
		servicioCliente = new ServicioCliente();
		clienteList = servicioCliente.lista();
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}
	
}
