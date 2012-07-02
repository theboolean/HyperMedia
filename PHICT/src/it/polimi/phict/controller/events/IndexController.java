package it.polimi.phict.controller.events;

import it.polimi.phict.service.EventManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static EventManagerService eventManager = EventManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("projectEvents", eventManager.selectAll());
        return forward("list.jsp");
    }
}
