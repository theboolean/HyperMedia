package it.polimi.phict.controller.events;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Event;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.EventManagerService;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class NextController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();
    private static EventManagerService eventManager =
        EventManagerService.get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project") && requestParameterExists("key")) {
            Key projectKey = parseKeyParameter("project");
            Key eventKey = parseKeyParameter("key");
            return showNextEvent(eventKey, projectKey);
        }

        throw new QueryException(
            "You must specify a valid project and event key.");

    }

    private Navigation showNextEvent(Key eventKey, Key projectKey) {
        Project project = projectManager.select(projectKey);
        Event event = eventManager.select(eventKey);
        List<Event> events = project.getEvents();
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getId().equals(event.getId())) {
                if (i == events.size() - 1) {
                    requestScope("event", events.get(0));
                } else {
                    requestScope("event", events.get(i + 1));
                }
                requestScope("project", project);
                requestScope("projectTheme", project.getTheme());
                return forward("show.jsp");
            }
        }
        requestScope("event", event);
        requestScope("project", project);
        requestScope("projectTheme", project.getTheme());
        return forward("show.jsp");
    }
}
