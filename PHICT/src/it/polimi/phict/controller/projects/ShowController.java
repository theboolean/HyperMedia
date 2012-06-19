package it.polimi.phict.controller.projects;

import it.polimi.phict.model.Project;
import it.polimi.phict.service.ErrorQueueService;
import it.polimi.phict.service.ProjectManagerService;
import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends Controller {
    private ProjectManagerService projectManager = ProjectManagerService.get();
    private ErrorQueueService errorQueue = ErrorQueueService.get();
    
    @Override
    public Navigation run() throws Exception {
        Key key = null;
        
        try {
            key = asKey("key");
        } catch (IllegalArgumentException iaex) {
            errorQueue.enqueue("The specified project does not exist.");
            return forward("/error");
        }
        
        if (key == null) {
            requestScope("projects", projectManager.selectAll());
            return forward("list.jsp");
        }
        
        Project project = projectManager.select(key);
        
        requestScope("project", project);
        
        return forward("show.jsp");
    }
}
