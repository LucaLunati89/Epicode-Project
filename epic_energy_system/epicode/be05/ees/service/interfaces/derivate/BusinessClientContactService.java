package it.epicode.be05.ees.service.interfaces.derivate;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.BusinessClientContact;
import it.epicode.be05.ees.service.interfaces.CrudService;

public interface BusinessClientContactService extends CrudService<BusinessClientContact> {

	public BusinessClientContact findByBusinessClient(BusinessClient bc);
	public BusinessClientContact updateBusinessClientContact(long id, BusinessClientContact entity, long idBusinessClient);

}
