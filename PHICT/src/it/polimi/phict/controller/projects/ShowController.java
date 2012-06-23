package it.polimi.phict.controller.projects;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.PartnerManagerService;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private ProjectManagerService projectManager = ProjectManagerService.get();
    private PartnerManagerService partnerManager = PartnerManagerService.get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key key = parseKeyParameter("key");
            Project project = projectManager.select(key);

            requestScope("project", project);
            requestScope("projectKey", project.getId());

            return forward("show.jsp");
        }

        if (requestParameterExists("partner")) {
            Key partnerKey = parseKeyParameter("partner");
            return showPartnersProject(partnerKey);
        }

        requestScope("projects", projectManager.selectAll());
        return forward("list.jsp");
    }

    private Navigation showPartnersProject(Key partnerKey) {
        List<Project> partnersProject =
            partnerManager.getPartnersProjects(partnerKey);
        requestScope("projects", partnersProject);
        return forward("list.jsp");
    }
}
