package it.polimi.phict.model;

import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;

import com.google.appengine.api.datastore.Key;

@Model
public class Partner {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private InverseModelListRef<Membership, Partner> membershipListRef = 
            new InverseModelListRef<Membership, Partner>(Membership.class, "partnerRef", this);

    @Attribute(persistent = false)
    private InverseModelListRef<Researcher, Partner> researcherListRef = 
            new InverseModelListRef<Researcher, Partner>(Researcher.class, "partnerRef", this);
    
    private String description;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    public List<Membership> getMemberships() {
        return membershipListRef.getModelList();
    }
    
    public List<Researcher> getResearchers() {
        return researcherListRef.getModelList();
    }
    
    public InverseModelListRef<Membership, Partner> getMembershipListRef() {
        return membershipListRef;
    }
    
    public InverseModelListRef<Researcher, Partner> getResearcherListRef() {
        return researcherListRef;
    }
}
