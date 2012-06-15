package it.polimi.phict.model;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import org.slim3.datastore.ModelRef;

import com.google.appengine.api.datastore.Key;

@Model
public class Activity {
    @Attribute(primaryKey = true)
    private Key id;

    @Attribute(persistent = false)
    private ModelRef<Project> projectRef = new ModelRef<Project>(Project.class);
    
    @Attribute(persistent = false)
    private InverseModelListRef<Result, Activity> resultListRef =
        new InverseModelListRef<Result, Activity>(Result.class, "activityRef", this);
    
    private String goals, schedule;
    
    public ModelRef<Project> getProjectRef() {
        return projectRef;
    }
    
    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
    
    public InverseModelListRef<Result, Activity> getResultListRef() {
        return resultListRef;
    }
}
