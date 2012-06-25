package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-25 19:16:33")
/** */
public final class ThemeProjectRelationMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.ThemeProjectRelation> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.ThemeProjectRelation, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.ThemeProjectRelation, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.ThemeProjectRelation, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project> projectRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.ThemeProjectRelation, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project>(this, "projectRef", "projectRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Project.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.ThemeProjectRelation, org.slim3.datastore.ModelRef<it.polimi.phict.model.Theme>, it.polimi.phict.model.Theme> themeRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.ThemeProjectRelation, org.slim3.datastore.ModelRef<it.polimi.phict.model.Theme>, it.polimi.phict.model.Theme>(this, "themeRef", "themeRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Theme.class);

    private static final ThemeProjectRelationMeta slim3_singleton = new ThemeProjectRelationMeta();

    /**
     * @return the singleton
     */
    public static ThemeProjectRelationMeta get() {
       return slim3_singleton;
    }

    /** */
    public ThemeProjectRelationMeta() {
        super("ThemeProjectRelation", it.polimi.phict.model.ThemeProjectRelation.class);
    }

    @Override
    public it.polimi.phict.model.ThemeProjectRelation entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.ThemeProjectRelation model = new it.polimi.phict.model.ThemeProjectRelation();
        model.setId(entity.getKey());
        if (model.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) is null.");
        }
        model.getProjectRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("projectRef"));
        if (model.getThemeRef() == null) {
            throw new NullPointerException("The property(themeRef) is null.");
        }
        model.getThemeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("themeRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.ThemeProjectRelation m = (it.polimi.phict.model.ThemeProjectRelation) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        if (m.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) must not be null.");
        }
        entity.setProperty("projectRef", m.getProjectRef().getKey());
        if (m.getThemeRef() == null) {
            throw new NullPointerException("The property(themeRef) must not be null.");
        }
        entity.setProperty("themeRef", m.getThemeRef().getKey());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.ThemeProjectRelation m = (it.polimi.phict.model.ThemeProjectRelation) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.ThemeProjectRelation m = (it.polimi.phict.model.ThemeProjectRelation) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.ThemeProjectRelation) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        it.polimi.phict.model.ThemeProjectRelation m = (it.polimi.phict.model.ThemeProjectRelation) model;
        if (m.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) must not be null.");
        }
        m.getProjectRef().assignKeyIfNecessary(ds);
        if (m.getThemeRef() == null) {
            throw new NullPointerException("The property(themeRef) must not be null.");
        }
        m.getThemeRef().assignKeyIfNecessary(ds);
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
        it.polimi.phict.model.ThemeProjectRelation m = (it.polimi.phict.model.ThemeProjectRelation) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getProjectRef() != null && m.getProjectRef().getKey() != null){
            writer.setNextPropertyName("projectRef");
            encoder0.encode(writer, m.getProjectRef(), maxDepth, currentDepth);
        }
        if(m.getThemeRef() != null && m.getThemeRef().getKey() != null){
            writer.setNextPropertyName("themeRef");
            encoder0.encode(writer, m.getThemeRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.ThemeProjectRelation jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.ThemeProjectRelation m = new it.polimi.phict.model.ThemeProjectRelation();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("projectRef");
        decoder0.decode(reader, m.getProjectRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("themeRef");
        decoder0.decode(reader, m.getThemeRef(), maxDepth, currentDepth);
        return m;
    }
}