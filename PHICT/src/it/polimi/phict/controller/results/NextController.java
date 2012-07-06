package it.polimi.phict.controller.results;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Project;
import it.polimi.phict.model.Result;
import it.polimi.phict.service.ActivityManagerService;
import it.polimi.phict.service.ResultManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class NextController extends PhictController {
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();
    private static ResultManagerService resultManager = ResultManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("activity") && requestParameterExists("key")) {
            Key activityKey = parseKeyParameter("activity");
            Key resultKey = parseKeyParameter("key");
            return showNextResult(resultKey, activityKey);
        }

        throw new QueryException(
            "You must specify a valid activity and result key.");
    }

    private Navigation showNextResult(Key resultKey, Key activityKey) {
        Activity activity = activityManager.select(activityKey);
        Result result = resultManager.select(resultKey);
        List<Result> results = activity.getResults();
        Project project = activity.getProject();
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).getId().equals(result.getId())) {
                if (i == results.size() - 1) {
                    requestScope("result", results.get(0));
                } else {
                    requestScope("result", results.get(i + 1));
                }
                requestScope("activity", activity);
                requestScope("project", project);
                requestScope("projectTheme", project.getTheme());
                return forward("show.jsp");
            }
        }
        requestScope("result", result);
        requestScope("activity", activity);
        requestScope("project", project);
        requestScope("projectTheme", project.getTheme());
        return forward("show.jsp");
    }
}
