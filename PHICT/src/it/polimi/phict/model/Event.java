package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Event {
    @Attribute(primaryKey = true)
    private Key id;

    @Attribute(persistent = false)
    private ModelRef<Project> projectRef = new ModelRef<Project>(Project.class);

    private String presentation;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Project getProject() {
        return projectRef.getModel();
    }

    public ModelRef<Project> getProjectRef() {
        return projectRef;
    }
}
