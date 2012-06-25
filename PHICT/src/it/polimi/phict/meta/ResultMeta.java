package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-25 21:29:40")
/** */
public final class ResultMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Result> {

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Result, org.slim3.datastore.ModelRef<it.polimi.phict.model.Activity>, it.polimi.phict.model.Activity> activityRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Result, org.slim3.datastore.ModelRef<it.polimi.phict.model.Activity>, it.polimi.phict.model.Activity>(this, "activityRef", "activityRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Activity.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Result, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Result, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Result, java.lang.Boolean> important = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Result, java.lang.Boolean>(this, "important", "important", java.lang.Boolean.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Result> overview = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Result>(this, "overview", "overview");

    private static final ResultMeta slim3_singleton = new ResultMeta();

    /**
     * @return the singleton
     */
    public static ResultMeta get() {
       return slim3_singleton;
    }

    /** */
    public ResultMeta() {
        super("Result", it.polimi.phict.model.Result.class);
    }

    @Override
    public it.polimi.phict.model.Result entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Result model = new it.polimi.phict.model.Result();
        if (model.getActivityRef() == null) {
            throw new NullPointerException("The property(activityRef) is null.");
        }
        model.getActivityRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("activityRef"));
        model.setId(entity.getKey());
        model.setImportant((java.lang.Boolean) entity.getProperty("important"));
        model.setOverview((java.lang.String) entity.getProperty("overview"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Result m = (it.polimi.phict.model.Result) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getActivityRef() == null) {
            throw new NullPointerException("The property(activityRef) must not be null.");
        }
        entity.setProperty("activityRef", m.getActivityRef().getKey());
        entity.setProperty("important", m.getImportant());
        entity.setProperty("overview", m.getOverview());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Result m = (it.polimi.phict.model.Result) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Result m = (it.polimi.phict.model.Result) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Result) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        it.polimi.phict.model.Result m = (it.polimi.phict.model.Result) model;
        if (m.getActivityRef() == null) {
            throw new NullPointerException("The property(activityRef) must not be null.");
        }
        m.getActivityRef().assignKeyIfNecessary(ds);
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
        it.polimi.phict.model.Result m = (it.polimi.phict.model.Result) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getActivityRef() != null && m.getActivityRef().getKey() != null){
            writer.setNextPropertyName("activityRef");
            encoder0.encode(writer, m.getActivityRef(), maxDepth, currentDepth);
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getImportant() != null){
            writer.setNextPropertyName("important");
            encoder0.encode(writer, m.getImportant());
        }
        if(m.getOverview() != null){
            writer.setNextPropertyName("overview");
            encoder0.encode(writer, m.getOverview());
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Result jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Result m = new it.polimi.phict.model.Result();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("activityRef");
        decoder0.decode(reader, m.getActivityRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("important");
        m.setImportant(decoder0.decode(reader, m.getImportant()));
        reader = rootReader.newObjectReader("overview");
        m.setOverview(decoder0.decode(reader, m.getOverview()));
        return m;
    }
}