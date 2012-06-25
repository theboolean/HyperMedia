package it.polimi.phict.controller.themes;

import it.polimi.phict.controller.PhictController;
import it.polimi.phict.meta.*;
import it.polimi.phict.service.*;

import java.util.Map;

import org.slim3.controller.Navigation;
import org.slim3.controller.validator.Validators;
import org.slim3.util.RequestMap;

public class NewController extends PhictController {
    private static ThemeManagerService themeManager = ThemeManagerService.get();

    @Override
    public Navigation run() throws Exception {
        Validators validators = new Validators(request);
        ThemeMeta meta = ThemeMeta.get();

        validators.add(meta.name, validators.required());
        validators.add(meta.description, validators.required());

        if (!validators.validate()) {
            return reportValidationErrors(validators.getErrors());
        }

        Map<String, Object> map = new RequestMap(request);

        themeManager.create(map);
        
        return forward("/themes/");
    }
}
