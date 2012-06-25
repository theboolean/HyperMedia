package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-25 19:16:09")
/** */
public final class ActivityMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Activity> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Activity> goals = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Activity>(this, "goals", "goals");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Activity, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Activity, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Activity, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project> projectRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Activity, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project>(this, "projectRef", "projectRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Project.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Activity> schedule = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Activity>(this, "schedule", "schedule");

    private static final ActivityMeta slim3_singleton = new ActivityMeta();

    /**
     * @return the singleton
     */
    public static ActivityMeta get() {
       return slim3_singleton;
    }

    /** */
    public ActivityMeta() {
        super("Activity", it.polimi.phict.model.Activity.class);
    }

    @Override
    public it.polimi.phict.model.Activity entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Activity model = new it.polimi.phict.model.Activity();
        model.setGoals((java.lang.String) entity.getProperty("goals"));
        model.setId(entity.getKey());
        if (model.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) is null.");
        }
        model.getProjectRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("projectRef"));
        model.setSchedule((java.lang.String) entity.getProperty("schedule"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Activity m = (it.polimi.phict.model.Activity) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("goals", m.getGoals());
        if (m.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) must not be null.");
        }
        entity.setProperty("projectRef", m.getProjectRef().getKey());
        entity.setProperty("schedule", m.getSchedule());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Activity m = (it.polimi.phict.model.Activity) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Activity m = (it.polimi.phict.model.Activity) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Activity) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        it.polimi.phict.model.Activity m = (it.polimi.phict.model.Activity) model;
        if (m.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) must not be null.");
        }
        m.getProjectRef().assignKeyIfNecessary(ds);
    }

    @Override
    protected void incrementVersion(Object model) {
    }

    @Override
    protected void prePut(Object model) {
    }

    @Override
    protected void postGet(Object model) {
    }

    @Override
    public String getSchemaVersionName() {
        return "slim3.schemaVersion";
    }

    @Override
    public String getClassHierarchyListName() {
        return "slim3.classHierarchyList";
    }

    @Override
    protected boolean isCipherProperty(String propertyName) {
        return false;
    }

    @Override
    protected void modelToJson(org.slim3.datastore.json.JsonWriter writer, java.lang.Object model, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Activity m = (it.polimi.phict.model.Activity) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getGoals() != null){
            writer.setNextPropertyName("goals");
            encoder0.encode(writer, m.getGoals());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getProjectRef() != null && m.getProjectRef().getKey() != null){
            writer.setNextPropertyName("projectRef");
            encoder0.encode(writer, m.getProjectRef(), maxDepth, currentDepth);
        }
        if(m.getSchedule() != null){
            writer.setNextPropertyName("schedule");
            encoder0.encode(writer, m.getSchedule());
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Activity jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Activity m = new it.polimi.phict.model.Activity();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("goals");
        m.setGoals(decoder0.decode(reader, m.getGoals()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("projectRef");
        decoder0.decode(reader, m.getProjectRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("schedule");
        m.setSchedule(decoder0.decode(reader, m.getSchedule()));
        return m;
    }
}