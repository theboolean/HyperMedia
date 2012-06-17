package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-15 19:03:54")
/** */
public final class MembershipMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Membership> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Membership, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Membership, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    private static final MembershipMeta slim3_singleton = new MembershipMeta();

    /**
     * @return the singleton
     */
    public static MembershipMeta get() {
       return slim3_singleton;
    }

    /** */
    public MembershipMeta() {
        super("Membership", it.polimi.phict.model.Membership.class);
    }

    @Override
    public it.polimi.phict.model.Membership entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Membership model = new it.polimi.phict.model.Membership();
        model.setId(entity.getKey());
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Membership m = (it.polimi.phict.model.Membership) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Membership m = (it.polimi.phict.model.Membership) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Membership m = (it.polimi.phict.model.Membership) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Membership) is not defined.");
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
        it.polimi.phict.model.Membership m = (it.polimi.phict.model.Membership) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Membership jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Membership m = new it.polimi.phict.model.Membership();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("partnerRef");
        decoder0.decode(reader, (org.slim3.datastore.ModelRef)null, maxDepth, currentDepth);
        reader = rootReader.newObjectReader("projectRef");
        decoder0.decode(reader, (org.slim3.datastore.ModelRef)null, maxDepth, currentDepth);
        return m;
    }
}