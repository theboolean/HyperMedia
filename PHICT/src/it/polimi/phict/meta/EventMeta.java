package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-25 21:29:40")
/** */
public final class EventMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Event> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Event, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Event, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Event> presentation = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Event>(this, "presentation", "presentation");

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Event, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project> projectRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Event, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project>(this, "projectRef", "projectRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Project.class);

    private static final EventMeta slim3_singleton = new EventMeta();

    /**
     * @return the singleton
     */
    public static EventMeta get() {
       return slim3_singleton;
    }

    /** */
    public EventMeta() {
        super("Event", it.polimi.phict.model.Event.class);
    }

    @Override
    public it.polimi.phict.model.Event entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Event model = new it.polimi.phict.model.Event();
        model.setId(entity.getKey());
        model.setPresentation((java.lang.String) entity.getProperty("presentation"));
        if (model.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) is null.");
        }
        model.getProjectRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("projectRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Event m = (it.polimi.phict.model.Event) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("presentation", m.getPresentation());
        if (m.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) must not be null.");
        }
        entity.setProperty("projectRef", m.getProjectRef().getKey());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Event m = (it.polimi.phict.model.Event) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Event m = (it.polimi.phict.model.Event) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Event) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        it.polimi.phict.model.Event m = (it.polimi.phict.model.Event) model;
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
        it.polimi.phict.model.Event m = (it.polimi.phict.model.Event) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getPresentation() != null){
            writer.setNextPropertyName("presentation");
            encoder0.encode(writer, m.getPresentation());
        }
        if(m.getProjectRef() != null && m.getProjectRef().getKey() != null){
            writer.setNextPropertyName("projectRef");
            encoder0.encode(writer, m.getProjectRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Event jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Event m = new it.polimi.phict.model.Event();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("presentation");
        m.setPresentation(decoder0.decode(reader, m.getPresentation()));
        reader = rootReader.newObjectReader("projectRef");
        decoder0.decode(reader, m.getProjectRef(), maxDepth, currentDepth);
        return m;
    }
}