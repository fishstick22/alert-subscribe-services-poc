package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ProgramProfileClientExceptionRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramProfileClientException;

@Service
public class ProgramProfileClientExceptionService implements IProgramProfileClientExceptionService {

	@Autowired
	private ProgramProfileClientExceptionRepository programProfileClientExceptionDAO;

	@Override
	public ProgramProfileClientException getProgramProfileClientExceptionById(Integer id) {
		ProgramProfileClientException obj = programProfileClientExceptionDAO.findOne(id);
		return obj;
	}

	@Override
	public List<ProgramProfileClientException> getAllProgramProfileClientExceptions() {
		return programProfileClientExceptionDAO.findAll();
	}

	@Override
	public ProgramProfileClientException addProgramProfileClientException(ProgramProfileClientException programProfileClientException) {
		return programProfileClientExceptionDAO.save(programProfileClientException);
	}

	@Override
	public void updateProgramProfileClientException(ProgramProfileClientException programProfileClientException) {
		programProfileClientExceptionDAO.save(programProfileClientException);
		
	}

	@Override
	public void deleteProgramProfileClientException(Integer id) {
		programProfileClientExceptionDAO.delete(id);
		
	}
}
