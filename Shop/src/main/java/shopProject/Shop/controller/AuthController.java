package shopProject.Shop.controller;

import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import shopProject.Shop.io.AuthRequest;
import shopProject.Shop.io.AuthResponse;
import shopProject.Shop.service.AppUserServiceDetails;
import shopProject.Shop.service.UserService;
import shopProject.Shop.util.JwtUtil;
@RestController
@RequiredArgsConstructor
public class AuthController {

	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final AppUserServiceDetails appUserServiceDetails;
	private final JwtUtil jwtUtil;
	private final UserService userService;
	
	
	@PostMapping("/login")
	public AuthResponse login (@RequestBody AuthRequest request) throws Exception{
		authenticate(request.getEmail(), request.getPassword());
		final UserDetails userDetails =appUserServiceDetails.loadUserByUsername(request.getEmail());
		final String jwtToken = jwtUtil.generateToken(userDetails);
		String user = userService.getUserRole(request.getEmail());
		return new AuthResponse(request.getEmail(),user,jwtToken);
	}
	
	public void authenticate (String email , String password) throws Exception {
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
		} catch (DisabledException e) {
			throw new Exception("User Disabled");
		} catch (BadCredentialsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Email or Password is Incorrect");
		}
	}
	
	@PostMapping("/encode")
	public String encodePassword (@RequestBody Map<String, String> request) {
		return passwordEncoder.encode(request.get("password"));
	}
	
}
