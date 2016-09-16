package io.github.lucasvenez.ormclass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * @author <a href="http://lucasvenez.github.io">Lucas Venezian Povoa</a>
 * @see <a href="https://docs.jboss.org/hibernate/orm/5.1/userguide/html_single/Hibernate_User_Guide.html#entity-inheritance">Hibernate Inheritance Mapping</a>
 */
@Entity
@Table
public class Individual extends Person {

	@Column
	private String individualDocument;

	public String getIndividualDocument() {
		return individualDocument;
	}

	public void setIndividualDocument(String individualDocument) {
		this.individualDocument = individualDocument;
	}
}
