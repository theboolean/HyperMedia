package it.polimi.phict.controller.results;

import it.polimi.phict.service.ResultManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static ResultManagerService resultManager = ResultManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("projectResults", resultManager.selectAll());
        return forward("list.jsp");
    }
}
