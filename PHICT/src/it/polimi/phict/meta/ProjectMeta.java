package it.polimi.phict.meta;

//@javax.annotation.Generated(value = { "slim3-gen", "@VERSION@" }, date = "2012-07-02 16:06:14")
/** */
public final class ProjectMeta extends org.slim3.datastore.ModelMeta<it.polimi.phict.model.Project> {

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project> description = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project>(this, "description", "description");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Project, java.lang.Integer> endYear = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Project, java.lang.Integer>(this, "endYear", "endYear", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Project, com.google.appengine.api.datastore.Key> id = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Project, com.google.appengine.api.datastore.Key>(this, "__key__", "id", com.google.appengine.api.datastore.Key.class);

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project> mainGoals = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project>(this, "mainGoals", "mainGoals");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project> name = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project>(this, "name", "name");

    /** */
    public final org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project> publicDocumentation = new org.slim3.datastore.StringAttributeMeta<it.polimi.phict.model.Project>(this, "publicDocumentation", "publicDocumentation");

    /** */
    public final org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Project, java.lang.Integer> startYear = new org.slim3.datastore.CoreAttributeMeta<it.polimi.phict.model.Project, java.lang.Integer>(this, "startYear", "startYear", java.lang.Integer.class);

    /** */
    public final org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Project, org.slim3.datastore.ModelRef<it.polimi.phict.model.Theme>, it.polimi.phict.model.Theme> themeRef = new org.slim3.datastore.ModelRefAttributeMeta<it.polimi.phict.model.Project, org.slim3.datastore.ModelRef<it.polimi.phict.model.Theme>, it.polimi.phict.model.Theme>(this, "themeRef", "themeRef", org.slim3.datastore.ModelRef.class, it.polimi.phict.model.Theme.class);

    private static final ProjectMeta slim3_singleton = new ProjectMeta();

    /**
     * @return the singleton
     */
    public static ProjectMeta get() {
       return slim3_singleton;
    }

    /** */
    public ProjectMeta() {
        super("Project", it.polimi.phict.model.Project.class);
    }

    @Override
    public it.polimi.phict.model.Project entityToModel(com.google.appengine.api.datastore.Entity entity) {
        it.polimi.phict.model.Project model = new it.polimi.phict.model.Project();
        model.setDescription((java.lang.String) entity.getProperty("description"));
        model.setEndYear(longToInteger((java.lang.Long) entity.getProperty("endYear")));
        model.setId(entity.getKey());
        model.setMainGoals((java.lang.String) entity.getProperty("mainGoals"));
        model.setName((java.lang.String) entity.getProperty("name"));
        model.setPublicDocumentation((java.lang.String) entity.getProperty("publicDocumentation"));
        model.setStartYear(longToInteger((java.lang.Long) entity.getProperty("startYear")));
        if (model.getThemeRef() == null) {
            throw new NullPointerException("The property(themeRef) is null.");
        }
        model.getThemeRef().setKey((com.google.appengine.api.datastore.Key) entity.getProperty("themeRef"));
        return model;
    }

    @Override
    public com.google.appengine.api.datastore.Entity modelToEntity(java.lang.Object model) {
        it.polimi.phict.model.Project m = (it.polimi.phict.model.Project) model;
        com.google.appengine.api.datastore.Entity entity = null;
        if (m.getId() != null) {
            entity = new com.google.appengine.api.datastore.Entity(m.getId());
        } else {
            entity = new com.google.appengine.api.datastore.Entity(kind);
        }
        entity.setProperty("description", m.getDescription());
        entity.setProperty("endYear", m.getEndYear());
        entity.setProperty("mainGoals", m.getMainGoals());
        entity.setProperty("name", m.getName());
        entity.setProperty("publicDocumentation", m.getPublicDocumentation());
        entity.setProperty("startYear", m.getStartYear());
        if (m.getThemeRef() == null) {
            throw new NullPointerException("The property(themeRef) must not be null.");
        }
        entity.setProperty("themeRef", m.getThemeRef().getKey());
        return entity;
    }

    @Override
    protected com.google.appengine.api.datastore.Key getKey(Object model) {
        it.polimi.phict.model.Project m = (it.polimi.phict.model.Project) model;
        return m.getId();
    }

    @Override
    protected void setKey(Object model, com.google.appengine.api.datastore.Key key) {
        validateKey(key);
        it.polimi.phict.model.Project m = (it.polimi.phict.model.Project) model;
        m.setId(key);
    }

    @Override
    protected long getVersion(Object model) {
        throw new IllegalStateException("The version property of the model(it.polimi.phict.model.Project) is not defined.");
    }

    @Override
    protected void assignKeyToModelRefIfNecessary(com.google.appengine.api.datastore.AsyncDatastoreService ds, java.lang.Object model) {
        it.polimi.phict.model.Project m = (it.polimi.phict.model.Project) model;
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
        it.polimi.phict.model.Project m = (it.polimi.phict.model.Project) model;
        writer.beginObject();
        org.slim3.datastore.json.Default encoder0 = new org.slim3.datastore.json.Default();
        if(m.getDescription() != null){
            writer.setNextPropertyName("description");
            encoder0.encode(writer, m.getDescription());
        }
        if(m.getEndYear() != null){
            writer.setNextPropertyName("endYear");
            encoder0.encode(writer, m.getEndYear());
        }
        if(m.getId() != null){
            writer.setNextPropertyName("id");
            encoder0.encode(writer, m.getId());
        }
        if(m.getMainGoals() != null){
            writer.setNextPropertyName("mainGoals");
            encoder0.encode(writer, m.getMainGoals());
        }
        if(m.getName() != null){
            writer.setNextPropertyName("name");
            encoder0.encode(writer, m.getName());
        }
        if(m.getPublicDocumentation() != null){
            writer.setNextPropertyName("publicDocumentation");
            encoder0.encode(writer, m.getPublicDocumentation());
        }
        if(m.getStartYear() != null){
            writer.setNextPropertyName("startYear");
            encoder0.encode(writer, m.getStartYear());
        }
        if(m.getThemeRef() != null && m.getThemeRef().getKey() != null){
            writer.setNextPropertyName("themeRef");
            encoder0.encode(writer, m.getThemeRef(), maxDepth, currentDepth);
        }
        writer.endObject();
    }

    @Override
    protected it.polimi.phict.model.Project jsonToModel(org.slim3.datastore.json.JsonRootReader rootReader, int maxDepth, int currentDepth) {
        it.polimi.phict.model.Project m = new it.polimi.phict.model.Project();
        org.slim3.datastore.json.JsonReader reader = null;
        org.slim3.datastore.json.Default decoder0 = new org.slim3.datastore.json.Default();
        reader = rootReader.newObjectReader("description");
        m.setDescription(decoder0.decode(reader, m.getDescription()));
        reader = rootReader.newObjectReader("endYear");
        m.setEndYear(decoder0.decode(reader, m.getEndYear()));
        reader = rootReader.newObjectReader("id");
        m.setId(decoder0.decode(reader, m.getId()));
        reader = rootReader.newObjectReader("mainGoals");
        m.setMainGoals(decoder0.decode(reader, m.getMainGoals()));
        reader = rootReader.newObjectReader("name");
        m.setName(decoder0.decode(reader, m.getName()));
        reader = rootReader.newObjectReader("publicDocumentation");
        m.setPublicDocumentation(decoder0.decode(reader, m.getPublicDocumentation()));
        reader = rootReader.newObjectReader("startYear");
        m.setStartYear(decoder0.decode(reader, m.getStartYear()));
        reader = rootReader.newObjectReader("themeRef");
        decoder0.decode(reader, m.getThemeRef(), maxDepth, currentDepth);
        return m;
    }
}