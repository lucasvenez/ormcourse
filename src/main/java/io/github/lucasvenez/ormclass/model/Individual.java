package io.github.lucasvenez.ormclass.model;

import java.io.Serializable;

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
public class Individual extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1509997359858778543L;
	
	@Column
	private String individualDocument;

	public Individual() {}
	
	public String getIndividualDocument() {
		return individualDocument;
	}

	public void setIndividualDocument(String individualDocument) {
		this.individualDocument = individualDocument;
	}
}
