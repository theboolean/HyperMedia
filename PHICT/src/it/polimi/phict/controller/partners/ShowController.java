package it.polimi.phict.controller.partners;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Partner;
import it.polimi.phict.service.PartnerManagerService;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static PartnerManagerService partnerManager = PartnerManagerService.get();

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
        // TODO
        return forward("/index");
    }

    private Navigation showPartners(Key partnersKey) {
        Partner researcher = partnerManager.select(partnersKey);
        requestScope("researcher", researcher);
        return forward("show.jsp");
    }
}
