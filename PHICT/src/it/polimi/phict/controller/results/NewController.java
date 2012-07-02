package it.polimi.phict.controller.results;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.ResultMeta;
import it.polimi.phict.service.ResultManagerService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static ResultManagerService resultManager = ResultManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ResultMeta meta = ResultMeta.get();

        validators.add("activity", validators.required());
        validators.add(meta.overview, validators.required());
        validators.add(meta.important, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        map.put("activity", asKey("activity"));

        resultManager.create(map);
        return forward("../admin.jsp");
    }
}
