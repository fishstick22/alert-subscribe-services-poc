package com.cvshealth.eccm.prototype.alertsubsvcpoc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private String name;
	private String description;
	private int chanEmailPriority;
	private int chanIvrPriority;
	private int chanSmsPriority;
	private int chanMailPriority;
	private int chanMobilePriority;
	private String chanDefault;
	private boolean required;
	private boolean mandatory;
	
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
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	public boolean isMandatory() {
		return mandatory;
	}
	public void setMandatory(boolean mandatory) {
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

}
