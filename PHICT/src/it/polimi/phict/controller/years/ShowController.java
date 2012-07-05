package it.polimi.phict.controller.years;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Integer year = Integer.parseInt(request.getParameter("key"));
            return showYearsProject(year);
        }
        throw new QueryException("You must specify a valid year");
    }

    private Navigation showYearsProject(Integer year) {
        List<Project> projects = projectManager.getProjectsByStartYear(year);
        requestScope("projects", projects);
        requestScope("year", year);
        return forward("show.jsp");
    }
}
