package it.polimi.phict.controller.events;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Event;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.EventManagerService;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();
    private static EventManagerService eventManager = EventManagerService.get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project")) {
            Key projectKey = parseKeyParameter("project");
            return showProjectEvents(projectKey);
        }

        if (requestParameterExists("key")) {
            Key activityKey = parseKeyParameter("key");
            return showEvents(activityKey);
        }

        throw new QueryException(
            "You must specify either a project whose events you want to view or a valid event key.");
    }

    private Navigation showProjectEvents(Key projectKey) {
        Project project = projectManager.select(projectKey);
        List<Event> projectEvents = project.getEvents();
        requestScope("project", project);
        requestScope("projectTheme",project.getTheme());
        requestScope("projectEvents", projectEvents);
        return forward("list.jsp");
    }

    private Navigation showEvents(Key key) {
        Event event = eventManager.select(key);
        Project project = event.getProject();
        requestScope("event", event);
        requestScope("project", project);
        requestScope("projectTheme",project.getTheme());
        return forward("show.jsp");
    }
}
