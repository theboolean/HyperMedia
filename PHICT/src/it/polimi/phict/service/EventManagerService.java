package it.polimi.phict.service;

import it.polimi.phict.meta.EventMeta;
import it.polimi.phict.model.Event;
import it.polimi.phict.model.Project;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class EventManagerService extends ModelManagerService<Event> {
    private static EventManagerService instance;

    public static synchronized EventManagerService get() {
        if (instance != null) {
            return instance;
        }

        return (instance = new EventManagerService());
    }

    private EventManagerService() {
        super(Event.class, EventMeta.get());
    }

    public Event create(Map<String, Object> rawData) {
        Event event = new Event();
        BeanUtil.copy(rawData, event);

        Project project =
            ProjectManagerService.get().select((Key) rawData.get("project"));

        event.getProjectRef().setModel(project);

        Transaction transaction = Datastore.beginTransaction();
        Datastore.put(event);
        transaction.commit();

        return event;
    }

}
