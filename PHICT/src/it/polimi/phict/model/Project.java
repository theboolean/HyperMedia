package it.polimi.phict.model;

import java.util.Iterator;
import java.util.List;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.InverseModelListRef;
import org.slim3.datastore.Model;
import com.google.appengine.api.datastore.Key;

@Model
public class Project {
    @Attribute(primaryKey = true)
    private Key id;
    
    @Attribute(persistent = false)
    private InverseModelListRef<Activity, Project> activityListRef = 
            new InverseModelListRef<Activity, Project>(Activity.class, "projectRef", this);
    
    private String name, description, mainGoals, publicDocumentation;
    
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

    public String getMainGoals() {
        return mainGoals;
    }

    public void setMainGoals(String mainGoals) {
        this.mainGoals = mainGoals;
    }

    public String getPublicDocumentation() {
        return publicDocumentation;
    }

    public void setPublicDocumentation(String publicDocumentation) {
        this.publicDocumentation = publicDocumentation;
    }
    
    
    public List<Activity> getActivities() {
        return activityListRef.getModelList();
    }
    
    public Iterable<Result> getImportantResults() {
        return new Iterable<Result>() {
            public Iterator<Result> iterator() {
                return new ImportantResultIterator();
            }
        };
    }
    
    
    private class ImportantResultIterator implements Iterator<Result> {
        Iterator<Activity> activityIterator;
        Iterator<Result> activityResultIterator;
        Result current;
        
        public boolean hasNext() {
            if (activityResultIterator == null) {
                return false;
            }
            
            do {
                while(activityResultIterator.hasNext()) {
                    Result result = activityResultIterator.next();
                    if (result.isImportant()) {
                        current = result;
                        return true;
                    }
                }
                    
                if (activityIterator.hasNext()) {
                    activityResultIterator = activityIterator.next().getResults().iterator();
                } else {
                    break;
                }
            } while (true);
            
            return false;
        }
        
        public Result next() {
            return current;
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public ImportantResultIterator() {
            this.activityIterator = getActivities().iterator();
            
            if (this.activityIterator.hasNext()) {
                this.activityResultIterator = activityIterator.next().getResults().iterator();
            }
        }
    }
}
