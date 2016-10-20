package org.ksoft.matriculas.ws.impl;

import javax.jws.WebService;

import org.ksoft.matriculas.ws.SeguimientoServices;
import org.slf4j.Logger;

@WebService(endpointInterface = "org.ksoft.matriculas.ws.SeguimientoServices")
public class SeguimientoServicesImpl implements SeguimientoServices {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(SeguimientoServicesImpl.class);

}
