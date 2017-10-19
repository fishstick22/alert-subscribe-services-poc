package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.dao.CommunicationRepository;
import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Communication;

@Service
public class CommunicationService implements ICommunicationService {

	@Autowired
	private CommunicationRepository communicationDAO;

	@Override
	public Communication getCommunicationById(Integer id) {
		Communication obj = communicationDAO.findOne(id);
		return obj;
	}
	
	@Override
	public List<Communication> getAllCommunications() {
		return communicationDAO.findAll();
	}
	
}
