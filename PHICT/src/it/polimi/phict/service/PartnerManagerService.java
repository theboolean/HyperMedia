package it.polimi.phict.service;

import it.polimi.phict.meta.PartnerMeta;
import it.polimi.phict.model.Membership;
import it.polimi.phict.model.Partner;
import it.polimi.phict.model.Project;

import java.util.ArrayList;
import java.util.List;
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

        Project project =
            ProjectManagerService.get().select((Key) rawData.get("project"));

        Membership membership = new Membership();
        membership.getPartnerRef().setModel(partner);
        membership.getProjectRef().setModel(project);

        Transaction transaction = Datastore.beginTransaction();
        Key partnerkey = Datastore.put(partner);
        transaction.commit();
        partner.setId(partnerkey);

        Transaction transaction2 = Datastore.beginTransaction();
        Key membershipKey = Datastore.put(membership);
        transaction2.commit();
        membership.setId(membershipKey);

        return partner;
    }

    public List<Project> getPartnersProjects(Key partnerKey) {
        List<Membership> membership =
            Datastore.query(Membership.class).asList();
        List<Project> project = new ArrayList<Project>();
        for (Membership m : membership) {
            if (m.getPartner().getId().equals(partnerKey)) {
                project.add(m.getProject());
            }
        }
        return project;
    }
}
