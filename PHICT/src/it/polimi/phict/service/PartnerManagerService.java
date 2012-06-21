package it.polimi.phict.service;

import it.polimi.phict.meta.PartnerMeta;
import it.polimi.phict.model.Partner;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class PartnerManagerService extends ModelManagerService<Partner> {
    private static PartnerManagerService instance;

    public static synchronized PartnerManagerService get() {
        if (instance != null) {
            return instance;
        }

        return (instance = new PartnerManagerService());
    }

    private PartnerManagerService() {
        super(Partner.class, PartnerMeta.get());
    }

    public Partner create(Map<String, Object> rawData) {
        Partner partner = new Partner();
        BeanUtil.copy(rawData, partner);

        Transaction transaction = Datastore.beginTransaction();
        Key key = Datastore.put(partner);
        transaction.commit();

        partner.setId(key);
        return partner;
    }
}
