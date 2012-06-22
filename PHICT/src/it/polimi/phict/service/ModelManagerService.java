package it.polimi.phict.service;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.datastore.ModelMeta;

import com.google.appengine.api.datastore.Key;

public abstract class ModelManagerService<T> {
    private Class<T> type;
    private ModelMeta<T> meta;

    public ModelManagerService(Class<T> type, ModelMeta<T> meta) {
        this.type = type;
        this.meta = meta;
    }

    public T select(Key key) {
        try {
            return Datastore.get(type, key);
        } catch (EntityNotFoundRuntimeException enfrex) {
            return null;
        } catch (IllegalArgumentException iaex) {
            return null;
        }
    }

    public List<T> selectAll() {
        return Datastore.query(meta).asList();
    }
}
