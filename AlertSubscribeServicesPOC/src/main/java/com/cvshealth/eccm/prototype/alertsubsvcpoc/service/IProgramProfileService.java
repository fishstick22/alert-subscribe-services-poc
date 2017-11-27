package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramProfile;

public interface IProgramProfileService {

	ProgramProfile getProgramProfileById(Integer id);

	List<ProgramProfile> getAllProgramProfiles();

	ProgramProfile addProgramProfile(ProgramProfile programProfile);

	void updateProgramProfile(ProgramProfile programProfile);

	void deleteProgramProfile(Integer id);
	
}
