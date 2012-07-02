package it.polimi.phict.controller.researchers;

import it.polimi.phict.service.ResearcherManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static ResearcherManagerService researcherManager = ResearcherManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("partnerResearchers", researcherManager.selectAll());
        return forward("list.jsp");
    }
}
