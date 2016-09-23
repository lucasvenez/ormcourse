package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Company extends Person implements Serializable {

	private static final long serialVersionUID = 17975402783719860L;
	
	@Column
	private String companyDocument;

	public String getCompanyDocument() {
		return companyDocument;
	}

	public void setCompanyDocument(String companyDocument) {
		this.companyDocument = companyDocument;
	}
}
