package it.polimi.phict.controller.researchers;

import it.polimi.phict.service.PartnerManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddController extends Controller {
    private static PartnerManagerService partnersManager =
        PartnerManagerService.get();

    @Override
    public Navigation run() throws Exception {
        requestScope("partners", partnersManager.selectAll());
        return forward("add.jsp");
    }
}
