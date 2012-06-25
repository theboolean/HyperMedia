package it.polimi.phict.service;

import it.polimi.phict.meta.ProjectMeta;
import it.polimi.phict.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

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
        
        Theme theme = ThemeManagerService.get().select((Key) rawData.get("theme"));
        project.getThemeRef().setModel(theme);

        Transaction transaction = Datastore.beginTransaction();
        Key key = Datastore.put(project);
        transaction.commit();

        project.setId(key);
        return project;
    }

    public List<Partner> getProjectPartners(Key projectKey) {
        List<Membership> membership =
            Datastore.query(Membership.class).asList();
        List<Partner> partners = new ArrayList<Partner>();
        for (Membership m : membership) {
            if (m.getProject().getId().equals(projectKey)) {
                partners.add(m.getPartner());
            }
        }
        return partners;
    }
}
