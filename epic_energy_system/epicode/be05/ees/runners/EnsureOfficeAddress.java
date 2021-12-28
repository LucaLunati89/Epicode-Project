package it.epicode.be05.ees.runners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.epicode.be05.ees.model.entity.BusinessClient;
import it.epicode.be05.ees.model.entity.OfficeAddress;
import it.epicode.be05.ees.model.util.OfficeType;
import it.epicode.be05.ees.service.interfaces.BusinessClientService;
import it.epicode.be05.ees.service.interfaces.derivate.OfficeAddressService;

@Component
public class EnsureOfficeAddress {

	private static final Logger log = LoggerFactory.getLogger(EnsureOfficeAddress.class);

	@Autowired
	BusinessClientService bcService;
	
	@Autowired
	OfficeAddressService oaService;
	
	int min = 1;
	int max = 99;
	
	public void createOfficeAddressLegal(int clients) {
		List<BusinessClient> bc = bcService.readAll();
		int j = 0;
		for(int i = 1; i <= clients; i++) {
			var oa = OfficeAddress.build()
				.setNameAddress("via sedelegale" + i)
				.setCivicNumber((int) Math.floor(Math.random()*(max-min+1)+min))
				.setPlace("posto" + i)
				.setCommune(null)
				.setZIPCode(i)
				.setType(OfficeType.LEGAL)
				.setBusinessClient(bc.get(j));
			oaService.create(oa);
			j++;
			log.info(oa.toString());
		}

	}
	
	public void createOfficeAddressOperational(int clients) {
		List<BusinessClient> bc = bcService.readAll();
		int j = 0;
		for(int i = 1; i <= clients / 2; i++) {
			var oa = OfficeAddress.build()
				.setNameAddress("via sedeoperativa" + i)
				.setCivicNumber((int) Math.floor(Math.random()*(max-min+1)+min))
				.setPlace("posto" + i)
				.setCommune(null)
				.setZIPCode(i)
				.setType(OfficeType.OPERATIONAL)
				.setBusinessClient(bc.get(j));
			oaService.create(oa);
			j++;
			log.info(oa.toString());
		}
	}
}
