package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

/**
 * This is a bridge entity to support the many-to-many relationship between partners and projects.
 */
@Model
public class Membership {
    @Attribute(primaryKey = true)
    private Key id;

    private ModelRef<Partner> partnerRef = new ModelRef<Partner>(Partner.class);

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

    public ModelRef<Partner> getPartnerRef() {
        return partnerRef;
    }

    public ModelRef<Project> getProjectRef() {
        return projectRef;
    }
}
