package it.polimi.phict.controller.results;

import it.polimi.phict.service.ActivityManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddController extends Controller {
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();

    @Override
    public Navigation run() throws Exception {
        requestScope("activities", activityManager.selectAll());
        return forward("add.jsp");
    }
}
