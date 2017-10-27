package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramConfiguration;

public interface IProgramConfigurationService {

	ProgramConfiguration getProgramConfigurationById(Integer id);

	List<ProgramConfiguration> getAllProgramConfigurations();

	ProgramConfiguration addProgramConfiguration(ProgramConfiguration programConfiguration);

	void updateProgramConfiguration(ProgramConfiguration programConfiguration);

	void deleteProgramConfiguration(Integer id);
	
}
