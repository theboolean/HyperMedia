package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-25 19:16:33")
/** */
public final class ThemeMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Theme> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Theme> description = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Theme>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Theme, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Theme, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Theme> name = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Theme>(this, "name", "name");

    private static final ThemeMeta slim3_singleton = new ThemeMeta();

    /**
     * @return the singleton
     */
    public static ThemeMeta get() {
       return slim3_singleton;
    }

    /** */
    public ThemeMeta() {
        super("Theme", it.polimi.phict.model.Theme.class);
    }

    @Override
    public it.polimi.phict.model.Theme entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Theme model = new it.polimi.phict.model.Theme();
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setId(entity.getKey());
        model.setName((java.lang.String) entity.getProperty("name"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Theme m = (it.polimi.phict.model.Theme) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("description", m.getDescription());
        entity.setProperty("name", m.getName());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Theme m = (it.polimi.phict.model.Theme) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Theme m = (it.polimi.phict.model.Theme) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Theme) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
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
        it.polimi.phict.model.Theme m = (it.polimi.phict.model.Theme) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Theme jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Theme m = new it.polimi.phict.model.Theme();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        return m;
    }
}