package it.polimi.phict.controller.partners;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Partner;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.PartnerManagerService;
import it.polimi.phict.service.ProjectManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();

    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project")) {
            Key projectKey = parseKeyParameter("project");
            return showProjectPartners(projectKey);
        }

        if (requestParameterExists("key")) {
            Key partnersKey = parseKeyParameter("key");
            return showPartners(partnersKey);
        }

        throw new QueryException(
            "You must specify either a project whose partners you want to view or a valid partner key.");
    }

    private Navigation showProjectPartners(Key projectKey) {
        Project project = projectManager.select(projectKey);
        List<Partner> projectPartners =
            projectManager.getProjectPartners(project);
        requestScope("project", project);
        requestScope("projectPartners", projectPartners);
        return forward("list.jsp");
    }

    private Navigation showPartners(Key partnersKey) {
        Partner researcher = partnerManager.select(partnersKey);
        requestScope("researcher", researcher);
        return forward("show.jsp");
    }
}
