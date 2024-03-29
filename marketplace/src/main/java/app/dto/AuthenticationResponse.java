package app.dto;

import app.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	private Long id;
	private String token;
	  private String email;
	  private String firstname;
	  private String lastname;
	  private ERole role;
  
}