package it.polimi.phict.model;

import org.slim3.datastore.*;

import com.google.appengine.api.datastore.*;

@Model
public class ThemeProjectRelation {
    @Attribute(primaryKey = true)
    private Key id;
    
    private ModelRef<Theme> themeRef = new ModelRef<Theme>(Theme.class);
    
    private ModelRef<Project> projectRef = new ModelRef<Project>(Project.class);

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }
    
    public Theme getTheme() {
        return themeRef.getModel();
    }
    
    public Project getProject() {
        return projectRef.getModel();
    }

    public ModelRef<Theme> getThemeRef() {
        return themeRef;
    }

    public ModelRef<Project> getProjectRef() {
        return projectRef;
    }
}
