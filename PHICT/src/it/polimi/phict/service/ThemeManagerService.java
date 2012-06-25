package it.polimi.phict.service;

import java.util.*;

import org.slim3.datastore.*;
import org.slim3.util.*;

import com.google.appengine.api.datastore.*;

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
    
    public Theme create(Map<String, Object> rawData) {
        Theme theme = new Theme();
        BeanUtil.copy(rawData, theme);
        
        Transaction transaction = Datastore.beginTransaction();
        Datastore.put(theme);
        transaction.commit();

        return theme;
    }
}
