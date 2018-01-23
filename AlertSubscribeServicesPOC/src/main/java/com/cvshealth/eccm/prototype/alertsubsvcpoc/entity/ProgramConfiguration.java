package com.cvshealth.eccm.prototype.alertsubsvcpoc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

//https://dzone.com/articles/circular-dependencies-jackson
@Entity
//https://stackoverflow.com/questions/15422838/jsonmappingexception-already-had-pojo-for-id
//https://stackoverflow.com/questions/44007188/deserialize-json-with-spring-unresolved-forward-references-jackson-exception
@JsonIdentityInfo(
		generator=ObjectIdGenerators.PropertyGenerator.class, 
		property="id",
		resolver = EntityIdResolver.class,
		scope = ProgramConfiguration.class)
public class ProgramConfiguration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1312813636559120957L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
//	private String name;
//	private String description;
	private int chanEmailPriority;
	private int chanIvrPriority;
	private int chanSmsPriority;
	private int chanSecurePriority;
	private int chanMailPriority;
	private int chanMobilePriority;
	private String chanDefault;
	private char required;
	private char mandatory;
	
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
	@JoinColumn(name="communication_id", nullable=false)
	@JsonIdentityReference(alwaysAsId = true)
	private Communication communication;	// DB FK
	
	public Communication getCommunication() {
		return communication;
	}
	public void setCommunication(Communication communication) {
		this.communication = communication;
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
	public int getChanEmailPriority() {
		return chanEmailPriority;
	}
	public void setChanEmailPriority(int chanEmailPriority) {
		this.chanEmailPriority = chanEmailPriority;
	}
	public int getChanIvrPriority() {
		return chanIvrPriority;
	}
	public void setChanIvrPriority(int chanIvrPriority) {
		this.chanIvrPriority = chanIvrPriority;
	}
	public int getChanSmsPriority() {
		return chanSmsPriority;
	}
	public void setChanSmsPriority(int chanSmsPriority) {
		this.chanSmsPriority = chanSmsPriority;
	}
	public int getChanSecurePriority() {
		return chanSecurePriority;
	}
	public void setChanSecurePriority(int chanSecurePriority) {
		this.chanSecurePriority = chanSecurePriority;
	}
	public int getChanMailPriority() {
		return chanMailPriority;
	}
	public void setChanMailPriority(int chanMailPriority) {
		this.chanMailPriority = chanMailPriority;
	}
	public int getChanMobilePriority() {
		return chanMobilePriority;
	}
	public void setChanMobilePriority(int chanMobilePriority) {
		this.chanMobilePriority = chanMobilePriority;
	}
	public String getChanDefault() {
		return chanDefault;
	}
	public void setChanDefault(String chanDefault) {
		this.chanDefault = chanDefault;
	}
	public char getRequired() {
		return required;
	}
	public void setRequired(char required) {
		this.required = required;
	}
	public char getMandatory() {
		return mandatory;
	}
	public void setMandatory(char mandatory) {
		this.mandatory = mandatory;
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
