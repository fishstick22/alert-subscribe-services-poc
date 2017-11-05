package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ClientConfigurationRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ClientConfiguration;

@Service
public class ClientConfigurationService implements IClientConfigurationService{

	@Autowired
	private ClientConfigurationRepository clientConfigurationDAO;

	@Override
	public ClientConfiguration getClientConfigurationById(Integer id) {
		ClientConfiguration obj = clientConfigurationDAO.findOne(id);
		return obj;
	}

	@Override
	public List<ClientConfiguration> getAllClientConfigurations() {
		return clientConfigurationDAO.findAll();
	}

	@Override
	public ClientConfiguration addClientConfiguration(ClientConfiguration clientConfiguration) {
		return clientConfigurationDAO.save(clientConfiguration);
	}

	@Override
	public void updateClientConfiguration(ClientConfiguration clientConfiguration) {
		clientConfigurationDAO.save(clientConfiguration);
		
	}

	@Override
	public void deleteClientConfiguration(Integer id) {
		clientConfigurationDAO.delete(id);
		
	}
}
