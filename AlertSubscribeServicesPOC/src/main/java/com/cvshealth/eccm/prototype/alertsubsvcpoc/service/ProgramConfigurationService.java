package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ProgramConfigurationRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramConfiguration;

@Service
public class ProgramConfigurationService implements IProgramConfigurationService {

	@Autowired
	private ProgramConfigurationRepository programConfigurationDAO;

	@Override
	public ProgramConfiguration getProgramConfigurationById(Integer id) {
		ProgramConfiguration obj = programConfigurationDAO.findOne(id);
		return obj;
	}

	@Override
	public List<ProgramConfiguration> getAllProgramConfigurations() {
		return programConfigurationDAO.findAll();
	}

	@Override
	public ProgramConfiguration addProgramConfiguration(ProgramConfiguration programConfiguration) {
		return programConfigurationDAO.save(programConfiguration);
	}

	@Override
	public void updateProgramConfiguration(ProgramConfiguration programConfiguration) {
		programConfigurationDAO.save(programConfiguration);
		
	}

	@Override
	public void deleteProgramConfiguration(Integer id) {
		programConfigurationDAO.delete(id);
		
	}
}
