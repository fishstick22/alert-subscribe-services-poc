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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private int displayOrder;
	private char defaultOptIn; // Y/N
	private char visibleInUi; // Y/N/P(romote)
	private char chanEmail; // Y/N
	private char chanIvr; // Y/N
	private char chanSms; // Y/N
	private char chanSecure; // Y/N
	private char chanMail; // Y/N
	private char chanMobile; // Y/N
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date effective;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date expiration;
	
	// housekeeping fields
	@Temporal(TemporalType.TIMESTAMP)
	//@Version
	private Date houseKpgCreateTime = new Date();
	
	private int houseKpgCreateTranCd = 0;
	private String houseKpgCreateUser = "CMP";
	
	private Date houseKpgUpdateTime = new Date();
	
	private int houseKpgUpdateTranCd = 0;
	private String houseKpgUpdateUser = "CMP";
	
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
	// @JsonIdentityReference(alwaysAsId = true)
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

	public int getDisplayOrder() {
		return displayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		this.displayOrder = displayOrder;
	}
	public char getDefaultOptIn() {
		return defaultOptIn;
	}
	public void setDefaultOptIn(char defaultOptIn) {
		this.defaultOptIn = defaultOptIn;
	}
	public char getVisibleInUi() {
		return visibleInUi;
	}
	public void setVisibleInUi(char visibleInUi) {
		this.visibleInUi = visibleInUi;
	}
	public char getChanEmail() {
		return chanEmail;
	}
	public void setChanEmail(char chanEmail) {
		this.chanEmail = chanEmail;
	}
	public char getChanIvr() {
		return chanIvr;
	}
	public void setChanIvr(char chanIvr) {
		this.chanIvr = chanIvr;
	}
	public char getChanSms() {
		return chanSms;
	}
	public void setChanSms(char chanSms) {
		this.chanSms = chanSms;
	}
	public char getChanSecure() {
		return chanSecure;
	}
	public void setChanSecure(char chanSecure) {
		this.chanSecure = chanSecure;
	}
	public char getChanMail() {
		return chanMail;
	}
	public void setChanMail(char chanMail) {
		this.chanMail = chanMail;
	}
	public char getChanMobile() {
		return chanMobile;
	}
	public void setChanMobile(char chanMobile) {
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
