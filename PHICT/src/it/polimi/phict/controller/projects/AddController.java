package it.polimi.phict.controller.projects;

import java.util.*;

import it.polimi.phict.model.*;
import it.polimi.phict.service.*;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public class AddController extends Controller {

    @Override
    public Navigation run() throws Exception {
        List<Theme> themes = ThemeManagerService.get().selectAll();
        requestScope("themes", themes);
        return forward("add.jsp");
    }
}
