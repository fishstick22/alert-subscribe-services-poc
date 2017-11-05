package com.cvshealth.eccm.prototype.alertsubsvcpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Client;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.service.IClientService;

@CrossOrigin 
@Controller
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private IClientService clientService;
	
	@RequestMapping(value="/client/{id}", method = RequestMethod.GET )
	public ResponseEntity<Client> getClientById(@PathVariable("id") Integer id) {
		Client client = clientService.getClientById(id);
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@RequestMapping(value= "/client", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> getAllClients() {
		List<Client> list = clientService.getAllClients();
		return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
	}
}
