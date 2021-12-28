package it.mybookingsystem.config;


import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.mybookingsystem.model.User;


public class UserDetailsImpl implements UserDetails{

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String email;
	@JsonIgnore
	private String password;
	private boolean accountNonLocked = true;
	private boolean accountNonExipered = false;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;
	private Date expirationTime;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserDetailsImpl (Long id, String userName, String email, String password, boolean enabled, 
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.accountNonLocked = enabled;
		this.accountNonExipered = enabled;
		this.credentialsNonExpired = enabled;
		this.enabled = enabled;
		this.authorities = authorities;
		
		}
	
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleType().name()))
				.collect(Collectors.toList());
		return new UserDetailsImpl(user.getId(), user.getUserName(), user.getEmail(), user.getPassword(), true, authorities);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExipered;
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

	String getUserName() {
		return userName;
	}

	void setUserName(String userName) {
		this.userName = userName;
	}

	String getEmail() {
		return email;
	}

	void setEmail(String email) {
		this.email = email;
	}

	void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public UserDetailsImpl setId(Long id) {
		this.id = id;
		return this;
	}

	boolean isAccountNonExipered() {
		return accountNonExipered;
	}

	void setAccountNonExipered(boolean accountNonExipered) {
		this.accountNonExipered = accountNonExipered;
	}

	Date getExpirationTime() {
		return expirationTime;
	}

	void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
}
