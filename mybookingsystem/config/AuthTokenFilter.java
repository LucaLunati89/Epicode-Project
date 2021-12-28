package it.mybookingsystem.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

public class AuthTokenFilter extends OncePerRequestFilter{

	private static final Logger log = LoggerFactory.getLogger(AuthTokenFilter.class);
	
	@Autowired
	JwtUtils jwt;
	
	UserDetailsServiceImpl userDetailsService;
	
	private static final String AUTH_HEADER = "Authorization";
	private static final String TOKEN_BEARER = "Bearer";
	
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	throws ServletException, IOException{
		log.info("In AuthTokenFilter");
		try {
			var header = request.getHeader(AUTH_HEADER);
			if (header != null && header.length() > 0 && header.startsWith(TOKEN_BEARER)) {
				var token = header.substring(TOKEN_BEARER.length());
				var userName = jwt.getUserNameFromToken(token);
				var details = userDetailsService.loadUserByUsername(userName);
				var authentication = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}catch (Exception e) {
			log.error("Impossibile costruire l'utente di applicazione");
		}
		filterChain.doFilter(request, response);
	}
}
