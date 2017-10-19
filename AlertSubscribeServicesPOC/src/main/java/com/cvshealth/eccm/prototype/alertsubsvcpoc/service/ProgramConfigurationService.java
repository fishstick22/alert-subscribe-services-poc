package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ProgramConfigurationRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ProgramRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramConfiguration;

@Service
public class ProgramConfigurationService implements IProgramConfigurationService {

	@Autowired
	private ProgramConfigurationRepository programConfigurationDAO;

	@Override
	public List<ProgramConfiguration> getAllProgramConfigurations() {
		return programConfigurationDAO.findAll();
	}
	
}
