package it.polimi.phict.service;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Provides services for storing error messages between controllers.
 */
public class ErrorQueueService {
    private static ErrorQueueService instance;

    private Queue<String> errorMessages;

    public static synchronized ErrorQueueService get() {
        if (instance != null) {
            return instance;
        }

        return (instance = new ErrorQueueService());
    }

    private ErrorQueueService() {
        this.errorMessages = new LinkedList<String>();
    }

    /**
     * Adds a message to the error queue.
     */
    public void enqueue(String errorMessage) {
        errorMessages.offer(errorMessage);
    }

    /**
     * Returns the first available message from the error queue and removes it from the
     * same queue.
     * @return Returns a fixed message if the error queue is empty.
     */
    public String dequeue() {
        String errorMessage = errorMessages.poll();

        if (errorMessage != null) {
            return errorMessage;
        }

        return "A generic error occurred.";
    }

    /**
     * Checks whether the error queue is empty.
     */
    public boolean isEmpty() {
        return errorMessages.isEmpty();
    }
}
