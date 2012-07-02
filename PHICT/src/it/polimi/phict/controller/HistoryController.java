package it.polimi.phict.controller;

import it.polimi.phict.model.Project;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class HistoryController extends Controller {
    private static ProjectManagerService projectManager = ProjectManagerService
            .get();
    
    @Override
    public Navigation run() throws Exception {
        List<Project> projects = projectManager.getProjectsByEndYear();
        requestScope("projects", projects);
        return forward("history.jsp");
    }
}