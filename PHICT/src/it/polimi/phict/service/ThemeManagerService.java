package it.polimi.phict.service;

import it.polimi.phict.meta.*;
import it.polimi.phict.model.*;

public class ThemeManagerService extends ModelManagerService<Theme> {
    private static ThemeManagerService instance;

    public static synchronized ThemeManagerService get() {
        if (instance != null) {
            return instance;
        }

        return (instance = new ThemeManagerService());
    }

    private ThemeManagerService() {
        super(Theme.class, ThemeMeta.get());
    }
}
