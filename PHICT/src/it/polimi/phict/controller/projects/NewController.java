package it.polimi.phict.controller.projects;

import java.util.Map;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.ProjectMeta;
import it.polimi.phict.service.ProjectManagerService;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private ProjectManagerService projectManager = ProjectManagerService.get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ProjectMeta meta = ProjectMeta.get();

        validators.add(meta.name, validators.required());
        validators.add(meta.description, validators.required());
        validators.add(meta.mainGoals, validators.required());
        validators.add(meta.startYear, validators.required());
        validators.add("theme", validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        map.put("theme", parseKeyParameter("theme"));
        projectManager.create(map);
        
        return forward("../admin.jsp");
    }
}
