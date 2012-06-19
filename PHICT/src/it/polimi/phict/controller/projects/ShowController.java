package it.polimi.phict.controller.projects;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.ProjectManagerService;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private ProjectManagerService projectManager = ProjectManagerService.get();
    
    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("key")) {
            Key key = parseKeyParameter("key");
            Project project = projectManager.select(key);
            
            requestScope("project", project);
            requestScope("projectKey", project.getId());
            
            return forward("show.jsp");
        }
        
        requestScope("projects", projectManager.selectAll());
        return forward("list.jsp");
    }
}
