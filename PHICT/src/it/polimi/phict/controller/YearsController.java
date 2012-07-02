package it.polimi.phict.controller;

import it.polimi.phict.model.Project;
import it.polimi.phict.service.ProjectManagerService;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class YearsController extends Controller {

    private static ProjectManagerService projectManager = ProjectManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        List<Integer> years = new ArrayList<Integer>();
        for (Project p : projectManager.selectAll()) {
            if (!years.contains(p.getStartYear())) {
                years.add(p.getStartYear());
            }
        }
        requestScope("years", years);
        return forward("years.jsp");
    }
}