package it.polimi.phict.controller.activities;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.ActivityManagerService;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class NextController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project") && requestParameterExists("key")) {
            Key projectKey = parseKeyParameter("project");
            Key activityKey = parseKeyParameter("key");
            return showNextActivity(activityKey, projectKey);
        }

        throw new QueryException(
            "You must specify a valid project and activity key.");

    }

    private Navigation showNextActivity(Key activityKey, Key projectKey) {
        Project project = projectManager.select(projectKey);
        Activity activity = activityManager.select(activityKey);
        List<Activity> activities = project.getActivities();
        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).getId().equals(activity.getId())) {
                if (i == activities.size() - 1) {

                    requestScope("activity", activities.get(0));
                } else {
                    requestScope("activity", activities.get(i + 1));
                }
                requestScope("project", project);
                requestScope("projectKey", project.getId());
                return forward("show.jsp");
            }
        }
        requestScope("activity", activity);
        requestScope("project", project);
        requestScope("projectKey", project.getId());
        return forward("show.jsp");
    }
}
