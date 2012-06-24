package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Researcher {
    @Attribute(primaryKey = true)
    private Key id;

    private ModelRef<Partner> partnerRef = new ModelRef<Partner>(Partner.class);

    private String curriculum, name, surname;

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }
    
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
