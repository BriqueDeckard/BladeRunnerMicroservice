package perso.replicantmicroservice.infrastructure.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	private static final String AUTH_TOKEN_HEADER_NAME = "X-API-KEY";
	private static final String AUTH_TOKEN = "DeQard";

	public static ApiKeyAuthentication getAuthentication(HttpServletRequest request) {
		String apiKey = request.getHeader(AUTH_TOKEN_HEADER_NAME);
		if (apiKey == null || !apiKey.equals(AUTH_TOKEN)) {
			throw new BadCredentialsException("Invalid API key");
		}
		return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
	}
}
