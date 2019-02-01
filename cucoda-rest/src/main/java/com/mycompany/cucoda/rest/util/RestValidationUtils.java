package com.mycompany.cucoda.rest.util;


import java.util.Arrays;
import java.util.regex.Pattern;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestValidationUtils {

    private RestValidationUtils() {
        // only static methods here..
    }


    public static void validateNotNullOrEmptyParameter(final String parameterValue, final String parameterName) {
        if (parameterValue == null || parameterValue.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity(String.format("required parameter %s was null or empty", parameterName))
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        }
    }

    public static void validateNotNullOrEmptyParameter(final String parameter) {
        if (parameter == null || parameter.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("required parameter was null or empty")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        }
    }

    public static void validateAllParametersAreNotNullOrEmpty(final String... parameters) {
        for (String parameter : parameters) {
            validateNotNullOrEmptyParameter(parameter);
        }
    }

    public static void validateNotNullParameter(final Boolean parameter) {
        if (parameter == null) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("required parameter: %s was null")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        }

    }

    public static void validateNotNullParameter(final Object parameter) {
        if (parameter == null) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("required parameter: %s was null")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        }

    }

    public static void validateAtLeastOneValidParameter(final String... parameters) {
        if (parameters != null) {
            for (final String parameter : parameters) {
                // Seems weird but yes, there are clients which try to pass "null" as parameter
                if (parameter != null && !parameter.isEmpty() && !"null".equals(parameter) && !"NULL".equals(parameter)) {
                    return;
                }
            }
        }

        throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                .entity("required parameter was null. Given: " + Arrays.toString(parameters))
                .type(MediaType.TEXT_PLAIN)
                .build());
    }

    public static void validateNoCompetingParameters(final String subscriptionId, final String... parameters) {
        if (subscriptionId != null && !subscriptionId.isEmpty()) {
            if (parameters != null) {
                for (final String parameter : parameters) {
                    if (parameter != null && !parameter.isEmpty()) {
                        throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                                .entity("Competing parameters found.")
                                .type(MediaType.TEXT_PLAIN)
                                .build());
                    }
                }
            }

        }

    }

    public static void validateComponentId(final String componentId) {
        if (!(Pattern.matches("([0-9])*-([0-9])*", componentId) || Pattern.matches("([0-9])*-null", componentId)
                || Pattern.matches("null-([0-9])*", componentId))) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("ComponentId did not match any valid pattern")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        }

    }

    public static void validateCsvList(final String input) {
        if (input != null && !input.isEmpty() && !Pattern.matches("([1-9][0-9]*,)*[1-9][0-9]*", input)) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Invalid list provided. Must contain either one element or a comma separated list")
                    .type(MediaType.TEXT_PLAIN)
                    .build());
        }

    }

    public static void valdateParametersAreNumericOrNull(final String... parameters) {
        for (final String parameter : parameters) {
            if (parameter != null) {
                try {
                    Long.valueOf(parameter);
                } catch (final NumberFormatException e) {
                    throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                            .entity("Parameter is not numeric: " + parameter)
                            .type(MediaType.TEXT_PLAIN)
                            .build());
                }
            }
        }

    }
}
