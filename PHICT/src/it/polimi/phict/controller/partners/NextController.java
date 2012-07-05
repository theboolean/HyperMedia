package it.polimi.phict.controller.partners;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Partner;
import it.polimi.phict.service.PartnerManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class NextController extends PhictController {
    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key partnersKey = parseKeyParameter("key");
            return showNextPartner(partnersKey);
        }

        throw new QueryException("You must specify a valid partner key.");

    }

    private Navigation showNextPartner(Key partnersKey) {
        List<Partner> partners = partnerManager.selectAll();
        Partner partner = partnerManager.select(partnersKey);
        for (int i = 0; i < partners.size(); i++) {
            if (partners.get(i).getId().equals(partner.getId())) {
                if (i == partners.size()-1) {
                    requestScope("partner", partners.get(0));
                    requestScope("partnerKey", partners.get(0).getId());
                } else {
                    requestScope("partner", partners.get(i + 1));
                    requestScope("partnerKey", partners.get(i + 1).getId());
                }
                return forward("show.jsp");
            }
        }
        requestScope("partner", partner);
        requestScope("partnerKey", partner.getId());
        return forward("show.jsp");
    }
}
