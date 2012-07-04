package it.polimi.phict.controller.themes;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Project;
import it.polimi.phict.model.Theme;
import it.polimi.phict.service.ThemeManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ThemeManagerService themeManager = ThemeManagerService
            .get();

    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key themeKey = parseKeyParameter("key");
            return showThemesProject(themeKey);
        }
        
        throw new QueryException(
            "You must specify a valid theme key.");
    }

    private Navigation showThemesProject(Key themeKey) {
        Theme theme = themeManager.select(themeKey);
        List<Project> projects = theme.getProjects();
        requestScope("projects", projects);
        requestScope("theme", theme);
        return forward("show.jsp");
    }
}
