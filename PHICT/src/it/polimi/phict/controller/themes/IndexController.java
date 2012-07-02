package it.polimi.phict.controller.themes;

import it.polimi.phict.service.ThemeManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class IndexController extends Controller {

    private static ThemeManagerService themeManager = ThemeManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        requestScope("themes", themeManager.selectAll());
        return forward("list.jsp");
    }
}
