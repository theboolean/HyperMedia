package it.polimi.phict.service;

import it.polimi.phict.meta.ResearcherMeta;
import it.polimi.phict.model.Partner;
import it.polimi.phict.model.Researcher;

import java.util.Map;

import org.slim3.datastore.Datastore;
import org.slim3.util.BeanUtil;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Transaction;

public class ResearcherManagerService extends ModelManagerService<Researcher> {
    private static ResearcherManagerService instance;

    public static synchronized ResearcherManagerService get() {
        if (instance != null) {
            return instance;
        }

        return (instance = new ResearcherManagerService());
    }

    private ResearcherManagerService() {
        super(Researcher.class, ResearcherMeta.get());
    }

    public Researcher create(Map<String, Object> rawData) {
        Researcher researcher = new Researcher();
        BeanUtil.copy(rawData, researcher);

        Partner partner =
            PartnerManagerService.get().select((Key) rawData.get("partner"));

        researcher.getPartnerRef().setModel(partner);

        Transaction transaction = Datastore.beginTransaction();
        Datastore.put(researcher);
        transaction.commit();

        return researcher;
    }

}
