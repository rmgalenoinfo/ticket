package com.ticket.cliente.accion;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.ticket.cliente.entidades.Prioridades;
import com.ticket.cliente.servicios.ServicioPrioridades;

@Named
@ViewScoped
public class PrioridadesLista implements Serializable {
	
	private List<Prioridades> prioridadesList;
	private ServicioPrioridades servicioPrioridades;
	
	@PostConstruct
	public void init() {
		servicioPrioridades = new ServicioPrioridades();
		prioridadesList = servicioPrioridades.lista();
	}

	public List<Prioridades> getPrioridadesList() {
		return prioridadesList;
	}

	public void setPrioridadesList(List<Prioridades> prioridadesList) {
		this.prioridadesList = prioridadesList;
	}

}
