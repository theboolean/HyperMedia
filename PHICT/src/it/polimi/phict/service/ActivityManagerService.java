package it.polimi.phict.service;

import it.polimi.phict.meta.ActivityMeta;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Project;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class ActivityManagerService extends ModelManagerService<Activity> {
    private static ActivityManagerService instance;

    public static synchronized ActivityManagerService get() {
        if (instance != null) {
            return instance;
        }

        return (instance = new ActivityManagerService());
    }

    private ActivityManagerService() {
        super(Activity.class, ActivityMeta.get());
    }

    public Activity create(Map<String, Object> rawData) {
        Activity activity = new Activity();
        BeanUtil.copy(rawData, activity);

        Project project =
            ProjectManagerService.get().select((Key) rawData.get("project"));

        activity.getProjectRef().setModel(project);

        Transaction transaction = Datastore.beginTransaction();
        Datastore.put(activity);
        transaction.commit();

        return activity;
    }
}
