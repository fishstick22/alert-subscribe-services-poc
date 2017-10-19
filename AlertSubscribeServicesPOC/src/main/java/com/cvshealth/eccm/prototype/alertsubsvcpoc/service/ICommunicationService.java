package com.cvshealth.eccm.prototype.alertsubsvcpoc.service;

import java.util.List;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Communication;

public interface ICommunicationService {

	Communication getCommunicationById(Integer id);

	List<Communication> getAllCommunications();
}
