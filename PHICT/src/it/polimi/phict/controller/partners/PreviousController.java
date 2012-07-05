package it.polimi.phict.controller.partners;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Partner;
import it.polimi.phict.service.PartnerManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class PreviousController extends PhictController {
    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key partnersKey = parseKeyParameter("key");
            return showPreviousPartner(partnersKey);
        }

        throw new QueryException("You must specify a valid partner key.");

    }

    private Navigation showPreviousPartner(Key partnersKey) {
        List<Partner> partners = partnerManager.selectAll();
        Partner partner = partnerManager.select(partnersKey);
        for (int i = 0; i < partners.size(); i++) {
            if (partners.get(i).getId().equals(partner.getId())) {
                if (i == 0) {
                    requestScope("partner", partners.get(partners.size()-1));
                    requestScope("partnerKey", partners.get(partners.size()-1).getId());
                } else {
                    requestScope("partner", partners.get(i - 1));
                    requestScope("partnerKey", partners.get(i - 1).getId());
                }
                return forward("show.jsp");
            }
        }
        requestScope("partner", partner);
        requestScope("partnerKey", partner.getId());
        return forward("show.jsp");
    }
}
