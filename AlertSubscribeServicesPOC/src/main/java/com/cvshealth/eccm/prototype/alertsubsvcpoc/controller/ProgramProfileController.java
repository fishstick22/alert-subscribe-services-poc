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

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.ProgramProfile;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.service.IProgramProfileService;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class ProgramProfileController {

	@Autowired
	private IProgramProfileService programProfileService;
	
	
	@RequestMapping(value="/programprofile/{id}", method = RequestMethod.GET )
	public ResponseEntity<ProgramProfile> getProgramProfileById(@PathVariable("id") Integer id) {
		ProgramProfile programProfile = programProfileService.getProgramProfileById(id);
		return new ResponseEntity<ProgramProfile>(programProfile, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/programprofile", method = RequestMethod.GET)
	public ResponseEntity<List<ProgramProfile>> getAllProgramProfiles() {
		List<ProgramProfile> list = programProfileService.getAllProgramProfiles();
		return new ResponseEntity<List<ProgramProfile>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/programprofile", method = RequestMethod.POST)
	public ResponseEntity<ProgramProfile> addProgramProfile(@RequestBody ProgramProfile programProfile, UriComponentsBuilder builder) {
        HttpHeaders headers = new HttpHeaders();
        ProgramProfile result = programProfileService.addProgramProfile(programProfile);
//        if (flag == false) {
//        	return new ResponseEntity<Void>(headers, HttpStatus.CONFLICT);
//        }

        headers.setLocation(builder.path("/programprofile/{id}").buildAndExpand(programProfile.getId()).toUri());
        return new ResponseEntity<ProgramProfile>(result, headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/programprofile/{id}", method = RequestMethod.PUT )
	public ResponseEntity<ProgramProfile> updateProgramProfile(@RequestBody ProgramProfile programProfile) {
		programProfileService.updateProgramProfile(programProfile);
		return new ResponseEntity<ProgramProfile>(programProfile, HttpStatus.OK);
	}
	
	@RequestMapping(value="/programprofile/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteProgramProfile(@PathVariable("id") Integer id) {
		programProfileService.deleteProgramProfile(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
