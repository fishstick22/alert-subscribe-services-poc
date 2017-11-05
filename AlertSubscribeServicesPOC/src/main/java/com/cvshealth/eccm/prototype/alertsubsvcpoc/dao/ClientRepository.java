package com.cvshealth.eccm.prototype.alertsubsvcpoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvshealth.eccm.prototype.alertsubsvcpoc.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{

}
