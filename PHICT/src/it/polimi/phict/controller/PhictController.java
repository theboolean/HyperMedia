package it.polimi.phict.controller;

import it.polimi.phict.service.ErrorQueueService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Errors;

import com.google.appengine.api.datastore.Key;

/**
 * Represents a controller for PHICT package. It is a wrapper for common use functions.
 */
public abstract class PhictController extends Controller {
    /**
     * An exception thrown because of the impossibility to complete a query (due to incoherent
     * results or malformed strings).
     */
    public static class QueryException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public QueryException(String message) {
            super(message);
        }
    }

    private static ErrorQueueService errorQueue = ErrorQueueService.get();

    /**
     * Handle any exception thrown in the {@link run} method, redirecting to a designated error page.
     */
    @Override
    public Navigation handleError(Throwable throwable) {
        String message = throwable.getMessage();

        if (message == null || message.equals("")) {
            errorQueue.enqueue("An exception of type "
                + throwable.getClass().getName()
                + " was thrown.");
            for (StackTraceElement elem : throwable.getStackTrace()) {
                errorQueue.enqueue(elem.toString());
            }
        } else {
            errorQueue.enqueue(message);
        }

        return forward("/error");
    }

    /**
     * Checks whether a parameter with the given name exists in the request body.
     */
    protected boolean requestParameterExists(String name) {
        return (request.getParameter(name) != null);
    }

    /**
     * Parse a base-64 encoded string parameter (whose name is specified as argument) into a datastore key.
     * @throws IllegalArgumentException If the key is not valid.
     * @throws NullPointerException If no such parameter exists.
     */
    protected Key parseKeyParameter(String name) {
        try {
            return asKey(name);
        } catch (IllegalArgumentException iaex) {
            throw iaex;
        } catch (NullPointerException npex) {
            return null;
        }
    }

    /**
     * Redirects the output to an error page displaying appropriate messages for the given error container.
     */
    protected Navigation reportValidationErrors(Errors errors) {
        errorQueue.enqueue("Some parameters were not correctly specified:");
        for (int i = 0; i < errors.size(); i++) {
            errorQueue.enqueue(errors.get(i));
        }
        return forward("/error");
    }
}
