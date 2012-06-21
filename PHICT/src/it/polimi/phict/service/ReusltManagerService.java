package it.polimi.phict.service;

import it.polimi.phict.meta.ResultMeta;
import it.polimi.phict.model.Activity;
import it.polimi.phict.model.Result;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class ReusltManagerService extends ModelManagerService<Result> {
    private static ReusltManagerService instance;
    
    public static synchronized ReusltManagerService get() {
        if (instance != null) {
            return instance;
        }
        
        return (instance = new ReusltManagerService());
    }
    
    private ReusltManagerService() { 
        super(Result.class, ResultMeta.get());
    }
    
    public Result create(Map<String, Object> rawData) {
        Result result = new Result();
        BeanUtil.copy(rawData, result);
        
        Activity activity = ActivityManagerService.get().select((Key)rawData.get("activity"));        
        result.getActivityRef().setModel(activity);
        
        Transaction transaction = Datastore.beginTransaction();
        Datastore.put(result);
        transaction.commit();
        
        return result;
    } 
}
