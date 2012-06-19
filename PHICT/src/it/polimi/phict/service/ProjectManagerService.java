package it.polimi.phict.service;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

import it.polimi.phict.meta.ProjectMeta;
import it.polimi.phict.model.Project;

public class ProjectManagerService extends ModelManagerService<Project> {
    private static ProjectManagerService instance;
    
    public static synchronized ProjectManagerService get() {
        if (instance != null) {
            return instance;
        }
        
        return (instance = new ProjectManagerService());
    }
    
    private ProjectManagerService() { 
        super(Project.class, ProjectMeta.get());
    }
    
    public Project create(Map<String, Object> rawData) {
        Project project = new Project();
        BeanUtil.copy(rawData, project);
        
        Transaction transaction = Datastore.beginTransaction();
        Key key = Datastore.put(project);
        transaction.commit();
        
        project.setId(key);
        return project;
    }
}
