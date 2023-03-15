package app.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import app.model.User;

public class UserDetailsImpl implements UserDetails {
	
	  private Long id;

	  private String email;

	  @JsonIgnore
	  private String password;

	  private GrantedAuthority authority;

	  public UserDetailsImpl(Long id, String username, String email, String password,
	      GrantedAuthority authority) {
	    this.id = id;
	    this.email = email;
	    this.password = password;
	    this.authority = authority;
	  }


	public static UserDetailsImpl build(User user) {
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());

		return new UserDetailsImpl((long) user.getId(), user.getUsername(), user.getEmail(), user.getPassword(), authority);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}
