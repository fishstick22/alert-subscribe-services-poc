package com.cvshealth.eccm.prototype.alertsubsvcpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Program;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.service.IProgramService;

@CrossOrigin 
@Controller
@RequestMapping("/api")
public class ProgramController {

	@Autowired
	private IProgramService programService;
	
	@RequestMapping(value="/program/{id}", method = RequestMethod.GET )
	public ResponseEntity<Program> getProgramById(@PathVariable("id") Integer id) {
		Program program = programService.getProgramById(id);
		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/program", method = RequestMethod.GET)
	public ResponseEntity<List<Program>> getAllPrograms() {
		List<Program> list = programService.getAllPrograms();
		return new ResponseEntity<List<Program>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/program", method = RequestMethod.POST)
	public ResponseEntity<Program> addProgram(@RequestBody Program program, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
		boolean flag = programService.addProgram(program);
        if (flag == false) {
        	return new ResponseEntity<Program>(program, headers, HttpStatus.CONFLICT);
        }

        headers.setLocation(builder.path("/program/{id}").buildAndExpand(program.getId()).toUri());
        return new ResponseEntity<Program>(program, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/program/{id}", method = RequestMethod.PUT )
	public ResponseEntity<Program> updateProgram(@RequestBody Program program) {
		programService.updateProgram(program);
		return new ResponseEntity<Program>(program, HttpStatus.OK);
	}
	
	@RequestMapping(value="/program/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteProgram(@PathVariable("id") Integer id) {
		programService.deleteProgram(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
