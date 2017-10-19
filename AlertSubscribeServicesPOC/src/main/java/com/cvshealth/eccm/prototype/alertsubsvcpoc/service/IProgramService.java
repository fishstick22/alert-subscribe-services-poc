package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;

public interface IProgramService {

	Program getProgramById(Integer id);

	List<Program> getAllPrograms();

	boolean addProgram(Program program);

	void updateProgram(Program program);

	void deleteProgram(Integer id);
}
