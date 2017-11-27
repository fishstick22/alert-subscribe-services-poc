package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ProgramProfileRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramProfile;

@Service
public class ProgramProfileService implements IProgramProfileService {

	@Autowired
	private ProgramProfileRepository programProfileDAO;

	@Override
	public ProgramProfile getProgramProfileById(Integer id) {
		ProgramProfile obj = programProfileDAO.findOne(id);
		return obj;
	}

	@Override
	public List<ProgramProfile> getAllProgramProfiles() {
		return programProfileDAO.findAll();
	}

	@Override
	public ProgramProfile addProgramProfile(ProgramProfile programProfile) {
		return programProfileDAO.save(programProfile);
	}

	@Override
	public void updateProgramProfile(ProgramProfile programProfile) {
		programProfileDAO.save(programProfile);
		
	}

	@Override
	public void deleteProgramProfile(Integer id) {
		programProfileDAO.delete(id);
		
	}
}
