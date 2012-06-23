package it.polimi.phict.controller.partners;

import it.polimi.phict.service.PartnerManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("projectPartners", partnerManager.selectAll());
        return forward("list.jsp");
    }
}
