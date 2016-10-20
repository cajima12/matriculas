package org.ksoft.matriculas.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.ksoft.matriculas.login.MatriculasUser;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.SortOrder;
import org.primefaces.model.StreamedContent;
import org.springframework.security.core.context.SecurityContextHolder;


public class Funciones {

	public static MatriculasUser getUsuarioLogado() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal.equals("anonymousUser")) {
			return null;
		}
		return (MatriculasUser) principal;
	}
	
	public static DefaultStreamedContent toStreamedContent(byte[] bytes) throws IOException {
		return new DefaultStreamedContent(new ByteArrayInputStream(bytes));
	}

	public static DefaultStreamedContent toStreamedContent(byte[] bytes, String tipo) throws IOException {
		return new DefaultStreamedContent(new ByteArrayInputStream(bytes), tipo);
	}
	
	public static StreamedContent toStreamedContent(File f) throws IOException {
		return new DefaultStreamedContent(new ByteArrayInputStream(FileUtils.readFileToByteArray(f)));
	}

	public static StreamedContent toStreamedContent(File f, String tipo_in) throws IOException {
		return new DefaultStreamedContent(new ByteArrayInputStream(FileUtils.readFileToByteArray(f)), tipo_in);
	}
	
	public static StreamedContent toStreamedContent(File f, String tipo_in, String tipo_out) throws IOException {
		return new DefaultStreamedContent(new ByteArrayInputStream(FileUtils.readFileToByteArray(f)), tipo_in, tipo_out);
	}

	public static Ordenacion getOrdenacion(SortOrder sortOrder) {
		switch (sortOrder) {
		case ASCENDING:
			return Ordenacion.ASC;
		case DESCENDING:	
			return Ordenacion.DESC;
		default:
			return Ordenacion.NO;
		}
	}
	
	public static Class<?> getClaseParametrizada(Object instancia, int posicion) {
		return ((Class<?>) ((ParameterizedType) instancia.getClass().getGenericSuperclass()).getActualTypeArguments()[posicion]);
	}
	
	public static String aString(List<? extends Object> lista, String campo) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		StringBuffer buffer = new StringBuffer();
		if (lista != null) {
			for (Object obj : lista) {
				if (buffer.length() > 0) {
					buffer.append(", ");
				}
				buffer.append(PropertyUtils.getProperty(obj, campo));
			}
		}
		return buffer.toString();
	
	}
	
}
