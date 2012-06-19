package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Result {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private ModelRef<Activity> activityRef = new ModelRef<Activity>(Activity.class);
    
    private String overview;
    private Boolean important;

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Boolean getImportant() {
        return important;
    }
    
    public void setImportant(Boolean important) {
        this.important = important;
    }
    
    
    public Activity getActivity() {
        return activityRef.getModel();
    }
    
    public Project getProject() {
        return activityRef.getModel().getProject();
    }
    
    public ModelRef<Activity> getActivityRef() {
        return activityRef;
    }
}
