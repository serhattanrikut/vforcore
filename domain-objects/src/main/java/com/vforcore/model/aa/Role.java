/**
 * 
 */
package com.vforcore.model.aa;

import java.util.Date;

import javax.persistence.Entity;

import org.springframework.security.core.GrantedAuthority;

import com.vforcore.model.persistence.BaseEntity;

/**
 * @author stanriku
 *
 */
@Entity
public class Role extends BaseEntity implements GrantedAuthority {

	private static final long serialVersionUID = 4434214805051813333L;
	
	private String name;
	private String description;
	
	/**
	 * 
	 */
	public Role() {
		super();
	}
	
	/**
	 * @param name
	 * @param description
	 */
	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	/**
	 * 
	 * @param id
	 * @param created
	 * @param name
	 * @param description
	 */
	public Role(Long id, Date created, String name, String description) {
		super(id,created);
		this.name = name;
		this.description = description;
	}
	

	@Override
	public String getAuthority() {
		return name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return super.equals(obj);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("Role [");
		builder.append(super.toString()).append(", ");
		builder.append("name=").append(name).append(", description=").append(description).append("]");
		return builder.toString();
	}

}
