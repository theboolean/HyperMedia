package it.polimi.phict.controller.events;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.EventMeta;
import it.polimi.phict.service.EventManagerService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static EventManagerService eventManager = EventManagerService.get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        EventMeta meta = EventMeta.get();

        validators.add("project", validators.required());
        validators.add(meta.presentation, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        map.put("project", asKey("project"));

        eventManager.create(map);
        return forward("../admin.jsp");
    }
}
