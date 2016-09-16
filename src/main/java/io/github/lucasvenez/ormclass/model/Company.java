package io.github.lucasvenez.ormclass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Company extends Person {

	@Column
	private String companyDocument;

	public String getCompanyDocument() {
		return companyDocument;
	}

	public void setCompanyDocument(String companyDocument) {
		this.companyDocument = companyDocument;
	}
}
