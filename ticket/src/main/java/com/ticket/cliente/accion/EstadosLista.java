package com.ticket.cliente.accion;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ticket.cliente.entidades.Estados;
import com.ticket.cliente.servicios.ServicioEstados;

@Named
@ViewScoped
public class EstadosLista implements Serializable{

	private List<Estados> estadosList;
	private ServicioEstados servicioEstados;
	
	@PostConstruct
	public void init() {
		servicioEstados = new ServicioEstados();
		estadosList = servicioEstados.lista();
	}

	public List<Estados> getEstadosList() {
		return estadosList;
	}

	public void setEstadosList(List<Estados> estadosList) {
		this.estadosList = estadosList;
	}
	
}
