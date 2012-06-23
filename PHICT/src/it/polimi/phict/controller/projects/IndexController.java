package it.polimi.phict.controller.projects;

import it.polimi.phict.service.ProjectManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static ProjectManagerService projectManager = ProjectManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("projects", projectManager.selectAll());
        return forward("list.jsp");
    }
}
