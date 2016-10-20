package org.ksoft.matriculas.login;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

@ManagedBean(name = "loginMgmtBean")
public class LoginBean {
	
	private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
	
	private static final String PAGINA_ERROR_LOGIN = "incorrect";
	private static final String PAGINA_PRINCIPAL = "/pages/secure/principal/index.xhtml?faces-redirect=true";

	private String userName = null;
	private String password = null;

	@ManagedProperty("#{authenticationManager}")
	private AuthenticationManager authenticationManager;

	@ManagedProperty("#{externalAuthenticationManager}")
	private ExternalAuthenticationManager externalAuthenticationManager;
	
	public String login() {
		try {
			Authentication request = new UsernamePasswordAuthenticationToken(this.getUserName(), this.getPassword());
			Authentication result = authenticationManager.authenticate(request);
			SecurityContextHolder.getContext().setAuthentication(result);
		} catch (AuthenticationException e) {
			log.error("Error login",e.getCause());
			FacesMessage msg = new FacesMessage("Error de autentificación", "Los datos introducidos no son válidos o no tiene permiso para acceder a esta aplicación.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return PAGINA_ERROR_LOGIN;
		}
		
		userName = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return PAGINA_PRINCIPAL;
	}

	public void loginFromParams(ComponentSystemEvent event) throws IOException {
		String token = (String) event.getComponent().getAttributes().get("authToken");

		if (token != null && !token.isEmpty()) {
			try {
				Authentication result = externalAuthenticationManager.authenticate(token);
				SecurityContextHolder.getContext().setAuthentication(result);
				HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
				FacesContext.getCurrentInstance().getExternalContext().redirect(req.getContextPath() +  PAGINA_PRINCIPAL);
			} catch (AuthenticationException e) {
				e.printStackTrace();
				FacesMessage msg = new FacesMessage("Error de autentificación", e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
	}

	public String cancel() {
		return null;
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		SecurityContextHolder.clearContext();
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return PAGINA_PRINCIPAL;
	}

	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	public void setExternalAuthenticationManager(ExternalAuthenticationManager externalAuthenticationManager) {
		this.externalAuthenticationManager = externalAuthenticationManager;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}