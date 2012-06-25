package it.polimi.phict.model;

import java.util.*;

import org.slim3.datastore.*;

import com.google.appengine.api.datastore.Key;

@Model
public class Theme {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private InverseModelListRef<Project, Theme> themeProjectRelationListRef = 
        new InverseModelListRef<Project, Theme>(
            Project.class, 
            "themeRef", 
            this);
    
    private String name, description;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public List<Project> getProjects() {
        return themeProjectRelationListRef.getModelList();
    }
    
    public InverseModelListRef<Project, Theme> getThemeProjectRelationListRef() {
        return themeProjectRelationListRef;
    }
}
