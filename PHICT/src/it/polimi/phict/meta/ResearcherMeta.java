package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-15 19:03:54")
/** */
public final class ResearcherMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Researcher> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Researcher> curriculum = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Researcher>(this, "curriculum", "curriculum");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Researcher, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Researcher, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    private static final ResearcherMeta slim3_singleton = new ResearcherMeta();

    /**
     * @return the singleton
     */
    public static ResearcherMeta get() {
       return slim3_singleton;
    }

    /** */
    public ResearcherMeta() {
        super("Researcher", it.polimi.phict.model.Researcher.class);
    }

    @Override
    public it.polimi.phict.model.Researcher entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Researcher model = new it.polimi.phict.model.Researcher();
        model.setCurriculum((java.lang.String) entity.getProperty("curriculum"));
        model.setId(entity.getKey());
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Researcher m = (it.polimi.phict.model.Researcher) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("curriculum", m.getCurriculum());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Researcher m = (it.polimi.phict.model.Researcher) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Researcher m = (it.polimi.phict.model.Researcher) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Researcher) is not defined.");
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
        it.polimi.phict.model.Researcher m = (it.polimi.phict.model.Researcher) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getCurriculum() != null){
            writer.setNextPropertyName("curriculum");
            encoder0.encode(writer, m.getCurriculum());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Researcher jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Researcher m = new it.polimi.phict.model.Researcher();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("curriculum");
        m.setCurriculum(decoder0.decode(reader, m.getCurriculum()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("partnerRef");
        decoder0.decode(reader, (org.slim3.datastore.ModelRef)null, maxDepth, currentDepth);
        return m;
    }
}