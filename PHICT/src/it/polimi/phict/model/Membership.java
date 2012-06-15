package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Membership {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private ModelRef<Partner> partnerRef = new ModelRef<Partner>(Partner.class);
    
    @Attribute(persistent = false)
    private ModelRef<Project> projectRef = new ModelRef<Project>(Project.class);

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    
    public Partner getPartner() {
        return partnerRef.getModel();
    }

    public Project getProject() {
        return projectRef.getModel();
    }
}
