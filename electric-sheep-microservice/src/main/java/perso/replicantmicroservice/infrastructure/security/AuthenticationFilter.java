package perso.replicantmicroservice.infrastructure.security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class AuthenticationFilter extends GenericFilterBean {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		try {
			ApiKeyAuthentication authentication = AuthenticationService.getAuthentication((HttpServletRequest) servletRequest);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}catch (Exception exception){
			HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
			httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
			PrintWriter writer = httpResponse.getWriter();
			writer.print(exception.getMessage());
			writer.flush();
			writer.close();
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
