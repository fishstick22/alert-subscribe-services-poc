package com.cvshealth.eccm.prototype.alertsubsvcpoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Communication;

public interface CommunicationRepository extends JpaRepository<Communication, Integer> {

}
