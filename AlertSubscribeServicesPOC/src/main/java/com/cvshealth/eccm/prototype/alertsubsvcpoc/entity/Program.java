package com.cvshealth.eccm.prototype.alertsubsvcpoc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = Program.class)
public class Program implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571336590866311408L;

	@Id
	private int id;
	private String name;
	private String description;
	
	// housekeeping fields
	@Temporal(TemporalType.TIMESTAMP)
	//@Version
	private Date houseKpgCreateTime = new Date();
	
	private int houseKpgCreateTranCd = 0;
	private String houseKpgCreateUser = "CMP";
	
	private Date houseKpgUpdateTime = new Date();
	
	private int houseKpgUpdateTranCd = 0;
	private String houseKpgUpdateUser = "CMP";
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="program")
	// @JsonIdentityReference(alwaysAsId = true)
	private Set<ProgramProfile> programProfile;
	
	public Set<ProgramProfile> getProgramProfile() {
		return programProfile;
	}
	public void setProgramProfile(Set<ProgramProfile> programProfile) {
		this.programProfile = programProfile;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="program")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ProgramProfileClientException> programProfileClientException;
	
	public Set<ProgramProfileClientException> getProgramProfileClientException() {
		return programProfileClientException;
	}
	public void setProgramProfileClientException(Set<ProgramProfileClientException> programProfileClientException) {
		this.programProfileClientException = programProfileClientException;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="program")
	@JsonIdentityReference(alwaysAsId = true)
	private Set<ProgramConfiguration> programConfiguration;

	public Set<ProgramConfiguration> getProgramConfiguration() {
		return programConfiguration;
	}
	public void setProgramConfiguration(Set<ProgramConfiguration> programConfiguration) {
		this.programConfiguration = programConfiguration;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getHouseKpgCreateTime() {
		return houseKpgCreateTime;
	}
	public void setHouseKpgCreateTime(Date houseKpgCreateTime) {
		this.houseKpgCreateTime = houseKpgCreateTime;
	}
	public int getHouseKpgCreateTranCd() {
		return houseKpgCreateTranCd;
	}
	public void setHouseKpgCreateTranCd(int houseKpgCreateTranCd) {
		this.houseKpgCreateTranCd = houseKpgCreateTranCd;
	}
	public String getHouseKpgCreateUser() {
		return houseKpgCreateUser;
	}
	public void setHouseKpgCreateUser(String houseKpgCreateUser) {
		this.houseKpgCreateUser = houseKpgCreateUser;
	}
	public Date getHouseKpgUpdateTime() {
		return houseKpgUpdateTime;
	}
	public void setHouseKpgUpdateTime(Date houseKpgUpdateTime) {
		this.houseKpgUpdateTime = houseKpgUpdateTime;
	}
	public int getHouseKpgUpdateTranCd() {
		return houseKpgUpdateTranCd;
	}
	public void setHouseKpgUpdateTranCd(int houseKpgUpdateTranCd) {
		this.houseKpgUpdateTranCd = houseKpgUpdateTranCd;
	}
	public String getHouseKpgUpdateUser() {
		return houseKpgUpdateUser;
	}
	public void setHouseKpgUpdateUser(String houseKpgUpdateUser) {
		this.houseKpgUpdateUser = houseKpgUpdateUser;
	}

}
