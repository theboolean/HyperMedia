package it.polimi.phict.controller.results;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.model.Project;
import it.polimi.phict.model.Result;
import it.polimi.phict.service.ProjectManagerService;
import it.polimi.phict.service.ReusltManagerService;

import java.util.List;

import org.slim3.controller.Navigation;

import com.google.appengine.api.datastore.Key;

public class ShowController extends PhictController {
    private static ProjectManagerService projectManager = ProjectManagerService.get();
    private static ReusltManagerService resultManager = ReusltManagerService.get();
    
    @Override
    public Navigation run() throws Exception {
        if (requestParameterExists("project")) {
            Key projectKey = parseKeyParameter("project");
            return showProjectResults(projectKey);
        }
        
        if (requestParameterExists("key")) {
            Key resultKey = parseKeyParameter("key");
            return showResults(resultKey);
        }
        
        throw new QueryException("You must specify either a project whose results you want to view or a valid result key.");
    }
    
    private Navigation showProjectResults(Key projectKey) {
        Project project = projectManager.select(projectKey);
        List<Result> projectResult = (List<Result>) project.getImportantResults();
        requestScope("project", project);
        requestScope("projectEvents", projectResult);
        return forward("list.jsp");
    }
    
    private Navigation showResults(Key key) {
        Result result = resultManager.select(key);
        requestScope("event", result);
        return forward("show.jsp");
    }
}
