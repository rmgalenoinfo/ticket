package com.ticket.cliente.dao;

import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ticket.cliente.interfaces.GenericoDAOInterface;
import com.ticket.cliente.utilidades.HibernateUtil;

public class GenericoDAOImplementa <T>  implements GenericoDAOInterface<T>{

	private Session sesionActual;
	private HibernateUtil sesionHibernate = new HibernateUtil();
	private Class<T> tipo;
	public Set<T> objects = new HashSet<T>();

	@SuppressWarnings("unused")
	private Session abriSession;

	@SuppressWarnings("unchecked")
	public GenericoDAOImplementa() {
		super();
		this.tipo = (Class<T>) getParameterClass(getClass(), 0);
	}

	@Override
	public T guardar(T entidad) {
		sesionActual = sesionHibernate.SesionTransaccion();
		sesionActual.saveOrUpdate(entidad);
//		sesionActual.persist(entidad);
		sesionHibernate.cerrarsesionTransaccion();
		return entidad;
	}

	@Override
	public T actualizar(T entidad) {
		// sesionActual = sesionHibernate.SesionTransaccion();
		sesionActual.update(entidad);
		sesionHibernate.cerrarTransaccion(sesionActual);
		return entidad;
	}

	@Override
	public void eliminar(T entidad) {
		// sesionActual = sesionHibernate.SesionTransaccion();
		sesionActual.delete(entidad);
		sesionHibernate.cerrarTransaccion(sesionActual);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T buscarId(Object id) {
		sesionActual = sesionHibernate.SesionTransaccion();
		sesionActual.find(tipo, id);
		return sesionActual.find(tipo, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> lista() {
		sesionActual = sesionHibernate.SesionTransaccion();
		Query<T> query = sesionActual.createQuery("from " + tipo.getSimpleName());
		return query.getResultList();
	}

	private static Class<?> getParameterClass(Class<?> clazz, int index) {
		return (Class<?>) (((ParameterizedType) clazz.getGenericSuperclass()).getActualTypeArguments()[index]);
	}

	public Session abriSession() {
		abriSession = null;
		return abriSession = sesionHibernate.SesionTransaccion();
	}

	public void cerrarSesion() {
		sesionHibernate.cerrarsesionTransaccion();
	}
	
}
