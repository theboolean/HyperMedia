package it.polimi.phict.service;

import java.util.List;

import org.slim3.datastore.Datastore;
import org.slim3.datastore.EntityNotFoundRuntimeException;
import org.slim3.datastore.ModelMeta;

import com.google.appengine.api.datastore.Key;

/**
 * Represents an abstract service used as a base class for an entity-specific manager service.
 * Provides basic functionalities for selection.
 */
public abstract class ModelManagerService<T> {
    private Class<T> type;
    private ModelMeta<T> meta;

    public ModelManagerService(Class<T> type, ModelMeta<T> meta) {
        this.type = type;
        this.meta = meta;
    }

    /**
     * Selects from the datastore an entity of type T with the given key.
     * @throws EntityNotFoundRuntimeException If the key belongs to no valid entities.
     * @throws IllegalArgumentException If the key is not valid itself.
     */
    public T select(Key key) {
        try {
            return Datastore.get(type, key);
        } catch (EntityNotFoundRuntimeException enfrex) {
            return null;
        } catch (IllegalArgumentException iaex) {
            return null;
        }
    }

    /**
     * Selects all the entities of the datastore that matches type T.
     * @return Returns an empty list if no entity of that type exist.
     */
    public List<T> selectAll() {
        return Datastore.query(meta).asList();
    }
}
