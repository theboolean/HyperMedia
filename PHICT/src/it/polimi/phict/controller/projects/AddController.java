package it.polimi.phict.controller.projects;

import it.polimi.phict.service.ThemeManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddController extends Controller {

    private static ThemeManagerService themesManager = ThemeManagerService.get();
    @Override
    public Navigation run() throws Exception {
        requestScope("themes", themesManager.selectAll());
        return forward("add.jsp");
    }
}
