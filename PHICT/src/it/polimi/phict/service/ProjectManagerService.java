package it.polimi.phict.service;

import it.polimi.phict.meta.ProjectMeta;
import it.polimi.phict.model.Membership;
import it.polimi.phict.model.Partner;
import it.polimi.phict.model.Project;
import it.polimi.phict.model.Theme;

import java.util.ArrayList;
import java.util.Collections;
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

        Theme theme =
            ThemeManagerService.get().select((Key) rawData.get("theme"));
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

    public List<Project> getProjectsByStartYear(Integer year) {
        List<Project> projects = new ArrayList<Project>();
        for (Project p : selectAll()) {
            if (p.getStartYear().equals(year)) {
                projects.add(p);
            }
        }
        return projects;
    }

    public List<Project> getProjectsByEndYear() {
        List<Project> projects = new ArrayList<Project>();
        for (Project p : selectAll()) {
            if (p.getEndYear() != null) {
                projects.add(p);
            }
        }
        return projects;
    }

    /**
     * @return a ordinate list of years in witch have started at least one
     *         project
     */
    public List<Integer> getAllProjectsYears() {
        List<Integer> years = new ArrayList<Integer>();
        for (Project p : selectAll()) {
            if (!years.contains(p.getStartYear())) {
                years.add(p.getStartYear());
            }
        }
        Collections.sort(years);
        return years;
    }
}
