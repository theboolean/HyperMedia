package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Researcher {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private ModelRef<Partner> partnerRef = new ModelRef<Partner>(Partner.class);
    
    private String curriculum;

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
    
    
    public Partner getPartner() {
        return partnerRef.getModel();
    }
    
    public ModelRef<Partner> getPartnerRef() {
        return partnerRef;
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }
}
