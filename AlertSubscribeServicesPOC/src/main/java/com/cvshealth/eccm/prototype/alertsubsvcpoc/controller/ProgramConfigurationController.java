package com.cvshealth.eccm.prototype.alertsubsvcpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramConfiguration;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.service.IProgramConfigurationService;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.service.IProgramService;

@CrossOrigin 
@Controller
@RequestMapping("/api")
public class ProgramConfigurationController {

	@Autowired
	private IProgramConfigurationService programConfigurationService;
	
	@RequestMapping(value= "/programconfiguration", method = RequestMethod.GET)
	public ResponseEntity<List<ProgramConfiguration>> getAllProgramConfigurations() {
		List<ProgramConfiguration> list = programConfigurationService.getAllProgramConfigurations();
		return new ResponseEntity<List<ProgramConfiguration>>(list, HttpStatus.OK);
	}
}
