package com.mycompany.cucoda.rest.mapper;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.Providers;

@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBException> {

//	@Inject
//	private Unilog logger;

	@Context
	private Providers providers;
	@Context
	private HttpHeaders headers;

	@Override
	public Response toResponse(EJBException exception) {
		while (exception.getCause() != null && exception.getCause() instanceof EJBException) {
			exception = (EJBException) exception.getCause();
		}
		final Exception cause = exception.getCausedByException();

		if (cause != null) {
			final ExceptionMapper delegate = providers.getExceptionMapper(cause.getClass());
			if (delegate != null) {
				return delegate.toResponse(cause);
			} else {
//				logger.error(cause.getMessage(), cause);
//				return Clerk.respond(ProblemType.SERVER_ERROR, null);
				return Response.serverError().build();
			}
		} else {
//			logger.error(exception.getMessage(), exception);
//			return Clerk.respond(ProblemType.SERVER_ERROR, exception.getMessage(), headers);
			return Response.serverError().build();
		}
	}

}
