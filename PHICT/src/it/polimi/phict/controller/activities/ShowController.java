package it.polimi.phict.controller.activities;

import java.util.List;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.ActivityManagerService;
import it.polimi.phict.service.ProjectManagerService;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService.get();
    private static ActivityManagerService activityManager = ActivityManagerService.get();
    
    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project")) {
            Key projectKey = parseKeyParameter("project");
            return showProjectActivities(projectKey);
        }
        
        if (requestParameterExists("key")) {
            Key activityKey = parseKeyParameter("key");
            return showActivity(activityKey);
        }
        
        throw new QueryException("You must specify either a project whose activities you want to view or a valid activity key.");
    }
    
    private Navigation showProjectActivities(Key projectKey) {
        Project project = projectManager.select(projectKey);
        List<Activity> projectActivities = project.getActivities();
        requestScope("project", project);
        requestScope("projectActivities", projectActivities);
        return forward("list.jsp");
    }
    
    private Navigation showActivity(Key key) {
        Activity activity = activityManager.select(key);
        requestScope("activity", activity);
        return forward("show.jsp");
    }
}
