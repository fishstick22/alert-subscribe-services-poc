package com.cvshealth.eccm.prototype.alertsubsvcpoc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id", scope = Program.class)
public class Program implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1571336590866311408L;

	@Id
	private int id;
	private String name;
	private String description;
	
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

}
