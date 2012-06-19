package it.polimi.phict.service;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import it.polimi.phict.meta.ActivityMeta;
import it.polimi.phict.model.Activity;

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
        
        activity.getProjectRef().setModel(ProjectManagerService.get().select((Key)rawData.get("project")));
        
        Transaction transaction = Datastore.beginTransaction();
        Datastore.put(activity);
        transaction.commit();
        
        return activity;
    } 
}
