package it.polimi.phict.model;

import java.util.*;

import org.slim3.datastore.*;

import com.google.appengine.api.datastore.Key;

@Model
public class Theme {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private InverseModelListRef<ThemeProjectRelation, Theme> themeProjectRelationListRef = 
        new InverseModelListRef<ThemeProjectRelation, Theme>(
            ThemeProjectRelation.class, 
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

    
    public List<ThemeProjectRelation> getThemeProjectRelations() {
        return themeProjectRelationListRef.getModelList();
    }
    
    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<Project>();
        
        for(ThemeProjectRelation relation : themeProjectRelationListRef.getModelList()) {
            projects.add(relation.getProject());
        }
        
        return projects;
    }
    
    
    public InverseModelListRef<ThemeProjectRelation, Theme> getThemeProjectRelationListRef() {
        return themeProjectRelationListRef;
    }
}
