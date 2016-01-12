/**
 * 
 */
package com.vforcore.model.persistence;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author stanriku
 *
 */
@MappedSuperclass
public abstract class BaseEntity {

	private int version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date created;

    public BaseEntity() {
    	super();
    	setCreated(Calendar.getInstance().getTime());
    }

    /**
	 * @param id
	 * @param created
	 */
	public BaseEntity(Long id, Date created) {
		this();
		this.id = id;
		this.created = created;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseEntity))
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("version=").append(version).append(", id=").append(id).append(", created=")
				.append(created);
		return builder.toString();
	}
}
