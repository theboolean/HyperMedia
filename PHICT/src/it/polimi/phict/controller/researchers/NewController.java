package it.polimi.phict.controller.researchers;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.ResearcherMeta;
import it.polimi.phict.service.ResearcherManagerService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static ResearcherManagerService researcherManager =
        ResearcherManagerService.get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ResearcherMeta meta = ResearcherMeta.get();

        validators.add("partner", validators.required());
        validators.add(meta.name, validators.required());
        validators.add(meta.surname, validators.required());
        validators.add(meta.curriculum, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        map.put("partner", asKey("partner"));

        researcherManager.create(map);
        return forward("../admin.jsp");
    }
}
