package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ClientRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Client;

@Service
public class ClientService implements IClientService {

	@Autowired
	private ClientRepository clientDAO;
	
	@Override
	public Client getClientById(Integer id) {
		Client obj = clientDAO.findOne(id);
		return obj;
	}

	@Override
	public List<Client> getAllClients() {
		return clientDAO.findAll();
	}

}
