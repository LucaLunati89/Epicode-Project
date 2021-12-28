package it.epicode.be05.ees.service.interfaces.derivate;

import java.util.List;

import org.springframework.data.domain.Pageable;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.OfficeAddress;
import it.epicode.be05.ees.model.util.OfficeType;
import it.epicode.be05.ees.service.interfaces.CrudService;

public interface OfficeAddressService extends CrudService<OfficeAddress> {
public List<OfficeAddress> findByBusinessClient(BusinessClient bc);
public List<OfficeAddress> findByType(Pageable pageable, OfficeType type);
public List<OfficeAddress> findByProvince(Pageable pageable, String name);

}
