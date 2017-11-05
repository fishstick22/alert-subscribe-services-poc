package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Client;

public interface IClientService {
	
	Client getClientById(Integer id);
	
	List<Client> getAllClients();
}
