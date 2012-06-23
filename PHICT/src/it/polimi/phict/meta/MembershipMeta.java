package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-06-22 20:58:40")
/** */
public final class MembershipMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Membership> {

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Membership, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Membership, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Membership, org.slim3.datastore.ModelRef<it.polimi.phict.model.Partner>, it.polimi.phict.model.Partner> partnerRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Membership, org.slim3.datastore.ModelRef<it.polimi.phict.model.Partner>, it.polimi.phict.model.Partner>(this, "partnerRef", "partnerRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Partner.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Membership, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project> projectRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Membership, org.slim3.datastore.ModelRef<it.polimi.phict.model.Project>, it.polimi.phict.model.Project>(this, "projectRef", "projectRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Project.class);

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
        if (model.getPartnerRef() == null) {
            throw new NullPointerException("The property(partnerRef) is null.");
        }
        model.getPartnerRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("partnerRef"));
        if (model.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) is null.");
        }
        model.getProjectRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("projectRef"));
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
        if (m.getPartnerRef() == null) {
            throw new NullPointerException("The property(partnerRef) must not be null.");
        }
        entity.setProperty("partnerRef", m.getPartnerRef().getKey());
        if (m.getProjectRef() == null) {
            throw new NullPointerException("The property(projectRef) must not be null.");
        }
        entity.setProperty("projectRef", m.getProjectRef().getKey());
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
        it.polimi.phict.model.Membership m = (it.polimi.phict.model.Membership) model;
        if (m.getPartnerRef() == null) {
            throw new NullPointerException("The property(partnerRef) must not be null.");
        }
        m.getPartnerRef().assignKeyIfNecessary(ds);
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
        it.polimi.phict.model.Membership m = (it.polimi.phict.model.Membership) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getPartnerRef() != null && m.getPartnerRef().getKey() != null){
            writer.setNextPropertyName("partnerRef");
            encoder0.encode(writer, m.getPartnerRef(), maxDepth, currentDepth);
        }
        if(m.getProjectRef() != null && m.getProjectRef().getKey() != null){
            writer.setNextPropertyName("projectRef");
            encoder0.encode(writer, m.getProjectRef(), maxDepth, currentDepth);
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
        decoder0.decode(reader, m.getPartnerRef(), maxDepth, currentDepth);
        reader = rootReader.newObjectReader("projectRef");
        decoder0.decode(reader, m.getProjectRef(), maxDepth, currentDepth);
        return m;
    }
}