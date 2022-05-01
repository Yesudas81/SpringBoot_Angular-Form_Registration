 package com.codingtips.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE_DTLS")
public class EmployeeModel {
	
	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private Integer eId;
	
	@Column(name="EMP_NAME")
	private String eName;
	
	@Column(name="EMP_EMAIL")
	private String eMail;
	
	@Column(name="EMP_GENDER")
	private String eGender;
	
	@Column(name="EMP_ADDR")
	private String eAddr;
	
	@ElementCollection
	@CollectionTable(name="EMP_PROJ_TAB", joinColumns = @JoinColumn(name="EMP_ID"))
	@Column(name="EMP_PROJ")
	private List<String> eProj;
	
	@ElementCollection
	@CollectionTable(name="EMP_SLOT_TAB", joinColumns = @JoinColumn(name="EMP_ID"))
	@Column(name="EMP_SLOT")
	private List<String> eSlot;
	

}
