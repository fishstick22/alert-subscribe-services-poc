package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramProfileClientException;

public interface IProgramProfileClientExceptionService {

	ProgramProfileClientException getProgramProfileClientExceptionById(Integer id);

	List<ProgramProfileClientException> getAllProgramProfileClientExceptions();

	ProgramProfileClientException addProgramProfileClientException(ProgramProfileClientException programProfileClientException);

	void updateProgramProfileClientException(ProgramProfileClientException programProfileClientException);

	void deleteProgramProfileClientException(Integer id);
	
}
