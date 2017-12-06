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
	public Program getProgramById(Integer id) {
		Program obj = programDAO.findOne(id);
		return obj;
	}
	
	@Override
	public List<Program> getAllPrograms() {
		return programDAO.findAll();
	}

	@Override
	public boolean addProgram(Program program) {
		if (programDAO.existsByName(program.getName())) {
			//logger.debug("addPerson " + person.getName() + " already Exists!");
			// TODO add logging and probably throw a custom exception like DuplicateProgramException
			return false;
		} else {
			programDAO.save(program);
			return true;
		}
	}

	@Override
	public void updateProgram(Program program) {
		programDAO.save(program);
		
	}

	@Override
	public void deleteProgram(Integer id) {
		programDAO.delete(id);
		
	}

	
}
