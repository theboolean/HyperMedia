package it.polimi.phict.controller.researchers;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Partner;
import it.polimi.phict.model.Researcher;
import it.polimi.phict.service.PartnerManagerService;
import it.polimi.phict.service.ResearcherManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static PartnerManagerService partnerManager = PartnerManagerService.get();
    private static ResearcherManagerService researcherManager = ResearcherManagerService.get();
    
    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("partner")) {
            Key partnerKey = parseKeyParameter("partner");
            return showPartnerResearchers(partnerKey);
        }
        
        if (requestParameterExists("key")) {
            Key researcherKey = parseKeyParameter("key");
            return showResearcher(researcherKey);
        }
        
        throw new QueryException("You must specify either a partner whose researchers you want to view or a valid researcher key.");
    }
    
    private Navigation showPartnerResearchers(Key partnerKey) {
        Partner partner = partnerManager.select(partnerKey);
        List<Researcher> partnerResearcher = partner.getResearchers();
        requestScope("partner", partner);
        requestScope("partnerResearcher", partnerResearcher);
        return forward("list.jsp");
    }
    
    private Navigation showResearcher(Key key) {
        Researcher researcher = researcherManager.select(key);
        requestScope("researcher", researcher);
        return forward("show.jsp");
    }
}
