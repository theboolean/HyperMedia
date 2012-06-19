package it.polimi.phict.service;

import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import it.polimi.phict.meta.ProjectMeta;
import it.polimi.phict.model.Project;

public class ProjectManagerService {
    private static ProjectManagerService instance;
    
    public static synchronized ProjectManagerService get() {
        if (instance != null) {
            return instance;
        }
        
        return (instance = new ProjectManagerService());
    }
    
    private ProjectManagerService() { }
    
    public Project create(Map<String, Object> rawData) {
        Project project = new Project();
        BeanUtil.copy(rawData, project);
        
        Transaction transaction = Datastore.beginTransaction();
        Key key = Datastore.put(project);
        transaction.commit();
        
        project.setId(key);
        return project;
    }
    
    public Project select(Key key) {
        try {
            return Datastore.get(Project.class, key);  
        } catch (EntityNotFoundRuntimeException enfrex) {
            return null;
        } catch (IllegalArgumentException iaex) {
            return null;
        }
    }
    
    public List<Project> selectAll() {
        return Datastore.query(ProjectMeta.get()).asList();
    }
}
