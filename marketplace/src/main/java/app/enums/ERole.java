package app.enums;

import org.springframework.security.core.GrantedAuthority;

public enum ERole implements GrantedAuthority {
	  ROLE_USER,
	  ROLE_ADMIN;
	  public String getAuthority() {
		    return name();
		  }
}
