package it.polimi.phict.model;

import java.util.*;

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
        new InverseModelListRef<Activity, Project>(
            Activity.class,
            "projectRef",
            this);

    @Attribute(persistent = false)
    private InverseModelListRef<Event, Project> eventsListRef =
        new InverseModelListRef<Event, Project>(
            Event.class, 
            "projectRef", 
            this);

    @Attribute(persistent = false)
    private InverseModelListRef<Membership, Project> membershipListRef =
        new InverseModelListRef<Membership, Project>(
            Membership.class,
            "partnerRef",
            this);
    
    @Attribute(persistent = false)
    private InverseModelListRef<ThemeProjectRelation, Project> themeProjectRelationListRef =
        new InverseModelListRef<ThemeProjectRelation, Project>(
            ThemeProjectRelation.class, 
            "projectRef", 
            this);

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

    public List<Event> getEvents() {
        return getEventsListRef().getModelList();
    }

    public List<Membership> getMemberships() {
        return membershipListRef.getModelList();
    }
    
    public List<ThemeProjectRelation> getThemeProjectRelations() {
        return themeProjectRelationListRef.getModelList();
    }
    
    public List<Theme> getThemes() {
        List<Theme> themes = new ArrayList<Theme>();
        
        for(ThemeProjectRelation relation : themeProjectRelationListRef.getModelList()) {
            themes.add(relation.getTheme());
        }
        
        return themes;
    }

    
    public InverseModelListRef<Activity, Project> getActivityListRef() {
        return activityListRef;
    }

    public InverseModelListRef<Event, Project> getEventListRef() {
        return getEventsListRef();
    }

    public InverseModelListRef<Membership, Project> getMembershipListRef() {
        return membershipListRef;
    }

    public InverseModelListRef<Event, Project> getEventsListRef() {
        return eventsListRef;
    }
    
    public InverseModelListRef<ThemeProjectRelation, Project> getThemeProjectRelationListRef() {
        return themeProjectRelationListRef;
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
                while (activityResultIterator.hasNext()) {
                    Result result = activityResultIterator.next();
                    if (result.getImportant()) {
                        current = result;
                        return true;
                    }
                }

                if (activityIterator.hasNext()) {
                    activityResultIterator =
                        activityIterator.next().getResults().iterator();
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
                this.activityResultIterator =
                    activityIterator.next().getResults().iterator();
            }
        }
    }
}
