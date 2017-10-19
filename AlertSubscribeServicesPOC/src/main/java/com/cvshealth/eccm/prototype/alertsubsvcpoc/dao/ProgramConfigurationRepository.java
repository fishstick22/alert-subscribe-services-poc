package com.cvshealth.eccm.prototype.alertsubsvcpoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramConfiguration;

public interface ProgramConfigurationRepository extends JpaRepository<ProgramConfiguration, Integer>{

}
