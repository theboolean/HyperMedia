package it.polimi.phict.controller.activities;

import it.polimi.phict.service.ActivityManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static ActivityManagerService activityManager = ActivityManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("projectActivities", activityManager.selectAll());
        return forward("list.jsp");
    }
}
