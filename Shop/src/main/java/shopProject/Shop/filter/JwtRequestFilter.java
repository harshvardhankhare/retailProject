package shopProject.Shop.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import shopProject.Shop.service.AppUserServiceDetails;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter{

	
	private final AppUserServiceDetails appUserServiceDetails;
	private final shopProject.Shop.util.JwtUtil jwtUtil;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	    
	   final String aH=	request.getHeader("Authorization");
	   String email =null;
	   String jwt = null;
	   if(aH != null && aH.startsWith("Bearer")) {
		  jwt= aH.substring(7);
		email=  jwtUtil.extractUsername(jwt);
	   }
	   if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
		   UserDetails userDetails = appUserServiceDetails.loadUserByUsername(email);
		   if(jwtUtil.validateToken(jwt,userDetails)){

			   UsernamePasswordAuthenticationToken  usernamePasswordAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			   usernamePasswordAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			   SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuth);
		   }
	   }
	   filterChain.doFilter(request,response);
		
	}
}
