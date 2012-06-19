package it.polimi.phict.controller;

import it.polimi.phict.service.ErrorQueueService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Errors;

import com.google.appengine.api.datastore.Key;

public abstract class PhictController extends Controller {
    public static class QueryException extends RuntimeException {
        private static final long serialVersionUID = 1L; 
        
        public QueryException(String message) {
            super(message);
        }
    }
    
    private static ErrorQueueService errorQueue = ErrorQueueService.get();
    
    @Override
    public Navigation handleError(Throwable throwable) {
        errorQueue.enqueue(throwable.getMessage());
        return forward("/error");
    }
    
    protected boolean requestParameterExists(String name) {
        return (request.getParameter(name) != null);
    }
    
    protected Key parseKeyParameter(String name) {
        try {
            return asKey(name);
        } catch (IllegalArgumentException iaex) {
            throw iaex;
        } catch (NullPointerException npex) {
            return null;
        }
    }
    
    protected Navigation reportValidationErrors(Errors errors) {
        for(int i = 0; i < errors.size(); i++) {
            errorQueue.enqueue(errors.get(i));
        }
        return forward("/error");
    }
}
