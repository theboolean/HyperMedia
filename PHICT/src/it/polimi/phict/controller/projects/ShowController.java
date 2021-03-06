package it.polimi.phict.controller.projects;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Event;
import it.polimi.phict.model.Project;
import it.polimi.phict.model.Theme;
import it.polimi.phict.service.ActivityManagerService;
import it.polimi.phict.service.EventManagerService;
import it.polimi.phict.service.PartnerManagerService;
import it.polimi.phict.service.ProjectManagerService;
import it.polimi.phict.service.ThemeManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();
    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();
    private static EventManagerService eventManager = EventManagerService.get();
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();
    private static ThemeManagerService themeManager = ThemeManagerService.get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key key = parseKeyParameter("key");
            Project project = projectManager.select(key);
            requestScope("theme", project.getTheme());
            requestScope("project", project);
            requestScope("projectKey", project.getId());

            return forward("show.jsp");
        }

        if (requestParameterExists("partner")) {
            Key partnerKey = parseKeyParameter("partner");
            return showPartnerProjects(partnerKey);
        }

        if (requestParameterExists("activity")) {
            Key activityKey = parseKeyParameter("activity");
            return showActivityProject(activityKey);
        }

        if (requestParameterExists("event")) {
            Key eventKey = parseKeyParameter("event");
            return showEventProject(eventKey);
        }

        if (requestParameterExists("theme")) {
            Key themeKey = parseKeyParameter("theme");
            return showThemedProjects(themeKey);
        }

        throw new QueryException(
            "You must specify either a project you want to view or a valid event, activity or partner key.");
    }

    private Navigation showEventProject(Key eventKey) {
        Event event = eventManager.select(eventKey);
        Project project = event.getProject();
        requestScope("project", project);
        return forward("show.jsp");
    }

    private Navigation showActivityProject(Key activityKey) {
        Activity activity = activityManager.select(activityKey);
        Project project = activity.getProject();
        requestScope("project", project);
        return forward("show.jsp");
    }

    private Navigation showPartnerProjects(Key partnerKey) {
        List<Project> partnersProject =
            partnerManager.getPartnersProjects(partnerKey);
        requestScope("projects", partnersProject);
        return forward("list.jsp");
    }

    private Navigation showThemedProjects(Key themeKey) {
        Theme theme = themeManager.select(themeKey);
        List<Project> projects = theme.getProjects();
        requestScope("projects", projects);
        return forward("list.jsp");
    }
}
