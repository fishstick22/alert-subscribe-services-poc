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
import com.cvshealth.eccm.prototype.alertsubsvcpoc.service.IProgramService;

@CrossOrigin 
@Controller
@RequestMapping("/service")
public class ProgramController {

	@Autowired
	private IProgramService programService;
	
	@RequestMapping(value= "/program", method = RequestMethod.GET)
	public ResponseEntity<List<Program>> getAllPrograms() {
		List<Program> list = programService.getAllPrograms();
		return new ResponseEntity<List<Program>>(list, HttpStatus.OK);
	}
	
}
