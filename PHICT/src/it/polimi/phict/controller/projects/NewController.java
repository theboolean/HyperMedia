package it.polimi.phict.controller.projects;

import it.polimi.phict.meta.ProjectMeta;
import it.polimi.phict.model.Project;
import it.polimi.phict.service.ErrorQueueService;
import it.polimi.phict.service.ProjectManagerService;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Errors;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends Controller {
    private ProjectManagerService projectManager = ProjectManagerService.get();
    private ErrorQueueService errorQueue = ErrorQueueService.get();
    
    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ProjectMeta meta = ProjectMeta.get();
        
        validators.add(meta.name, validators.required());
        validators.add(meta.description, validators.required());
        validators.add(meta.mainGoals, validators.required());
        
        if (!validators.validate()) {
            Errors errors = validators.getErrors();
            
            for(int i = 0; i < errors.size(); i++) {
                errorQueue.enqueue(errors.get(i));
            }
            
            return forward("/error");
        }
        
        Project result = projectManager.create(new RequestMap(request));
        
        return forward("show?key=" + result.getId());
    }
}
