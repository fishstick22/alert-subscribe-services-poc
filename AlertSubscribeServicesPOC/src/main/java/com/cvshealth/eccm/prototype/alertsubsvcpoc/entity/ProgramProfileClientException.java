package com.cvshealth.eccm.prototype.alertsubsvcpoc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = ProgramProfileClientException.class)
public class ProgramProfileClientException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1998700964863311421L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	private String name;
//	private String description;
	private boolean defaultOptIn = false;
	private boolean visibleInUi = false;
	private boolean chanEmail = false;
	private boolean chanIvr = false;
	private boolean chanSms = false;
	private boolean chanSecure = false;
	private boolean chanMail = false;
	private boolean chanMobile = false;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiration;
	
	@ManyToOne
	@JoinColumn(name="program_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Program program;	// DB FK

	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	
	@ManyToOne
	@JoinColumn(name="client_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Client client;	// DB FK
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
	public boolean isDefaultOptIn() {
		return defaultOptIn;
	}
	public void setDefaultOptIn(boolean defaultOptIn) {
		this.defaultOptIn = defaultOptIn;
	}
	public boolean isVisibleInUi() {
		return visibleInUi;
	}
	public void setVisibleInUi(boolean visibleInUi) {
		this.visibleInUi = visibleInUi;
	}
	public boolean isChanEmail() {
		return chanEmail;
	}
	public void setChanEmail(boolean chanEmail) {
		this.chanEmail = chanEmail;
	}
	public boolean isChanIvr() {
		return chanIvr;
	}
	public void setChanIvr(boolean chanIvr) {
		this.chanIvr = chanIvr;
	}
	public boolean isChanSms() {
		return chanSms;
	}
	public void setChanSms(boolean chanSms) {
		this.chanSms = chanSms;
	}
	public boolean isChanSecure() {
		return chanSecure;
	}
	public void setChanSecure(boolean chanSecure) {
		this.chanSecure = chanSecure;
	}
	public boolean isChanMail() {
		return chanMail;
	}
	public void setChanMail(boolean chanMail) {
		this.chanMail = chanMail;
	}
	public boolean isChanMobile() {
		return chanMobile;
	}
	public void setChanMobile(boolean chanMobile) {
		this.chanMobile = chanMobile;
	}
	public Date getEffective() {
		return effective;
	}
	public void setEffective(Date effective) {
		this.effective = effective;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

}
