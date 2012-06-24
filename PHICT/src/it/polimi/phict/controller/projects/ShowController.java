package it.polimi.phict.controller.projects;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.ActivityManagerService;
import it.polimi.phict.service.EventManagerService;
import it.polimi.phict.service.PartnerManagerService;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private ProjectManagerService projectManager = ProjectManagerService.get();
    private PartnerManagerService partnerManager = PartnerManagerService.get();
    private EventManagerService eventManager = EventManagerService.get();
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key key = parseKeyParameter("key");
            Project project = projectManager.select(key);

            requestScope("project", project);
            requestScope("projectKey", project.getId());

            return forward("show.jsp");
        }

        if (requestParameterExists("partner")) {
            Key partnerKey = parseKeyParameter("partner");
            return showPartnersProject(partnerKey);
        }

        if (requestParameterExists("activity")) {
            Key activityKey = parseKeyParameter("activity");
            return showActivityProject(activityKey);
        }

        if (requestParameterExists("event")) {
            Key eventKey = parseKeyParameter("event");
            return showEventProject(eventKey);
        }

        throw new QueryException(
            "You must specify either a project you want to view or a valid event, activity or partner key.");
    }

    private Navigation showEventProject(Key eventKey) {
        Project eventProject = eventManager.getProjectByEvent(eventKey);
        requestScope("project", eventProject);
        requestScope("projectKey", eventProject.getId());
        return forward("show.jsp");
    }

    private Navigation showActivityProject(Key activityKey) {
        Project activityProject =
            activityManager.getProjectByActivity(activityKey);
        requestScope("project", activityProject);
        requestScope("projectKey", activityProject.getId());
        return forward("show.jsp");
    }
    private Navigation showPartnersProject(Key partnerKey) {
        List<Project> partnersProject =
            partnerManager.getPartnersProjects(partnerKey);
        requestScope("projects", partnersProject);
        return forward("list.jsp");
    }
}
