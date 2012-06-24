package it.polimi.phict.controller.activities;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.ActivityMeta;
import it.polimi.phict.service.ActivityManagerService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static ActivityManagerService activityManager =
        ActivityManagerService.get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ActivityMeta meta = ActivityMeta.get();

        validators.add("project", validators.required());
        validators.add(meta.schedule, validators.required());
        validators.add(meta.goals, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        String projectKey = map.get("project").toString();
        map.put("project", asKey("project"));

        activityManager.create(map);
        return forward("/projects/show?key=" + projectKey);
    }
}
