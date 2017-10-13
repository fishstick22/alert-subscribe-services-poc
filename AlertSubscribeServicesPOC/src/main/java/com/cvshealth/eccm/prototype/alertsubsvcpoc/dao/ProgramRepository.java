package com.cvshealth.eccm.prototype.alertsubsvcpoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer>{

}
