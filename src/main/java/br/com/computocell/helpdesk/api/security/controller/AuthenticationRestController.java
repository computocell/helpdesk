package br.com.computocell.helpdesk.api.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.computocell.helpdesk.api.entity.User;
import br.com.computocell.helpdesk.api.security.jwt.JwtAuthenticationRequest;
import br.com.computocell.helpdesk.api.security.jwt.JwtTokenUtil;
import br.com.computocell.helpdesk.api.security.model.CurrentUser;
import br.com.computocell.helpdesk.api.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationRestController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	private UserService userService;

	@PostMapping(value = "/api/auth")
	public ResponseEntity<?> createdAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) {
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
						authenticationRequest.getPassword())

				);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		final String token = jwtTokenUtil.generateToken(userDetails);
		final User user = userService.findByEmail(authenticationRequest.getEmail());
		user.setPassword(null);
		return ResponseEntity.ok(new CurrentUser(token, user));

	}

}
