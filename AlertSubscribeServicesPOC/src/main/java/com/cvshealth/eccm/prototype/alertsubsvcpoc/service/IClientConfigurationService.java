package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ClientConfiguration;

public interface IClientConfigurationService {

	ClientConfiguration getClientConfigurationById(Integer id);

	List<ClientConfiguration> getAllClientConfigurations();

	ClientConfiguration addClientConfiguration(ClientConfiguration programConfiguration);

	void updateClientConfiguration(ClientConfiguration programConfiguration);

	void deleteClientConfiguration(Integer id);
}
