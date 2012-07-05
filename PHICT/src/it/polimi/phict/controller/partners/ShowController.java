package it.polimi.phict.controller.partners;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Partner;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.PartnerManagerService;
import it.polimi.phict.service.ProjectManagerService;
import it.polimi.phict.service.ResearcherManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService
        .get();

    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();
    
    private static ResearcherManagerService researcherManager = ResearcherManagerService
            .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project")) {
            Key projectKey = parseKeyParameter("project");
            return showProjectPartners(projectKey);
        }
        
        if (requestParameterExists("researcher")) {
            Key researcherKey = parseKeyParameter("researcher");
            return showResearcherPartner(researcherKey);
        }

        if (requestParameterExists("key")) {
            Key partnersKey = parseKeyParameter("key");
            return showPartner(partnersKey);
        }

        throw new QueryException(
            "You must specify either a project whose partners you want to view or a valid partner key.");
    }
    
    private Navigation showProjectPartners(Key projectKey) {
        Project project = projectManager.select(projectKey);
        List<Partner> projectPartners =
            projectManager.getProjectPartners(projectKey);
        requestScope("project", project);
        requestScope("projectTheme", project.getTheme());
        requestScope("projectPartners", projectPartners);
        return forward("list.jsp");
    }

    private Navigation showResearcherPartner(Key researcherKey) {
        Partner researcherPartner =
            researcherManager.getPartnerByResearcher(researcherKey);
        requestScope("partner", researcherPartner);
        requestScope("partnerKey", researcherPartner.getId());
        return forward("show.jsp");
    }

    private Navigation showPartner(Key partnersKey) {
        Partner partner = partnerManager.select(partnersKey);
        requestScope("partner", partner);
        requestScope("partnerKey", partner.getId());
        return forward("show.jsp");
    }
}
