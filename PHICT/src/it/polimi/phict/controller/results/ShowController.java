package it.polimi.phict.controller.results;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Project;
import it.polimi.phict.model.Result;
import it.polimi.phict.service.ActivityManagerService;
import it.polimi.phict.service.ProjectManagerService;
import it.polimi.phict.service.ResultManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();
    private static ResultManagerService resultManager = ResultManagerService
        .get();
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("activity")) {
            Key activityKey = parseKeyParameter("activity");
            return showActivityResults(activityKey);
        }

        if (requestParameterExists("project")) {
            Key projectkey = parseKeyParameter("project");
            return showImportantProjectResults(projectkey);
        }

        if (requestParameterExists("key")) {
            Key resultKey = parseKeyParameter("key");
            return showResults(resultKey);
        }

        throw new QueryException(
            "You must specify either an activity whose results you want to view or a valid result key.");
    }

    private Navigation showImportantProjectResults(Key projectkey) {
        Project project = projectManager.select(projectkey);
        List<Result> projectResults =
            (List<Result>) project.getImportantResults();
        requestScope("projectResults", projectResults);
        return forward("list.jsp");
    }

    private Navigation showActivityResults(Key activityKey) {
        Activity activity = activityManager.select(activityKey);
        List<Result> activityResults = (List<Result>) activity.getResults();
        Project project = activity.getProject();
        requestScope("projectResults", activityResults);
        requestScope("activity", activity);
        requestScope("project", project);
        requestScope("projectTheme", project.getTheme());
        return forward("list.jsp");
    }

    private Navigation showResults(Key key) {
        Result result = resultManager.select(key);
        Activity activity = result.getActivity();
        Project project = activity.getProject();
        requestScope("result", result);
        requestScope("activity", activity);
        requestScope("project", project);
        requestScope("projectTheme", project.getTheme());
        return forward("show.jsp");
    }
}
