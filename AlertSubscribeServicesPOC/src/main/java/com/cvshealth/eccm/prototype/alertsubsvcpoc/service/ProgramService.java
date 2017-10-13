package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.ProgramRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;

@Service
public class ProgramService implements IProgramService {

	@Autowired
	private ProgramRepository programDAO;

	@Override
	public List<Program> getAllPrograms() {
		return programDAO.findAll();
	}
	
}
