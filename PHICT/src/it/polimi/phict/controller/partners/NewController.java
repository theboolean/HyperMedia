package it.polimi.phict.controller.partners;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.PartnerMeta;
import it.polimi.phict.service.PartnerManagerService;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static PartnerManagerService partnerManager = PartnerManagerService
        .get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        PartnerMeta meta = PartnerMeta.get();

        validators.add("project", validators.required());
        validators.add(meta.name, validators.required());
        validators.add(meta.description, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);
        map.put("project", asKey("project"));

        partnerManager.create(map);
        return forward("../admin.jsp");
    }
}
