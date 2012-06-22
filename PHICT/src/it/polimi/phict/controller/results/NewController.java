package it.polimi.phict.controller.results;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.ResultMeta;
import it.polimi.phict.service.ReusltManagerService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static ReusltManagerService resultManager = ReusltManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ResultMeta meta = ResultMeta.get();

        validators.add("activity", validators.required());
        validators.add(meta.overview, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        String activityKey = map.get("activity").toString();
        map.put("activity", asKey("activity"));

        resultManager.create(map);
        return forward("/activities/show?key=" + activityKey);
    }
}
