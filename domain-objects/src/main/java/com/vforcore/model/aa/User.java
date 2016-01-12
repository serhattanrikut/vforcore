package com.vforcore.model.aa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vforcore.model.persistence.BaseEntity;

/**
 * @author stanriku
 *
 */
@Entity
public class User extends BaseEntity implements UserDetails, Serializable {

	private static final long serialVersionUID = 999694101206189552L;
	
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = false;
	
	@ManyToOne(cascade = {CascadeType.REFRESH}, optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name="ROLE_ID")
	private Role role;
	
	/**
	 * 
	 */
	public User() {
		super();
	}
	
	
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 * @param password
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 */
	public User(String firstName, String lastName, String email, String username, String password,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}
	
	/**
	 * @param id
	 * @param created
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param username
	 * @param password
	 * @param accountNonExpired
	 * @param accountNonLocked
	 * @param credentialsNonExpired
	 * @param enabled
	 */
	public User(Long id, Date created, String firstName, String lastName, String email, String username, String password,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super(id,created);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param accountNonExpired the accountNonExpired to set
	 */
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	/**
	 * @param accountNonLocked the accountNonLocked to set
	 */
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	/**
	 * @param credentialsNonExpired the credentialsNonExpired to set
	 */
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return super.equals(obj);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("User [");
		builder.append(super.toString()).append(", ");
		builder.append("firstName=").append(firstName).append(", lastName=").append(lastName).append(", email=")
				.append(email).append(", username=").append(username).append(", password=").append(password)
				.append(", accountNonExpired=").append(accountNonExpired).append(", accountNonLocked=")
				.append(accountNonLocked).append(", credentialsNonExpired=").append(credentialsNonExpired)
				.append(", enabled=").append(enabled).append(", role=").append(role).append("]");
		return builder.toString();
	}
	
}
