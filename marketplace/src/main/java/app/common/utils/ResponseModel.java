package app.common.utils;

import app.dto.AuthenticationResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {

		  private int statusCode;
		  private String message;
	  
}
