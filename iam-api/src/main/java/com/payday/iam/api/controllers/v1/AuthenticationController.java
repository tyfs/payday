package com.payday.iam.api.controllers.v1;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.payday.iam.api.security.SecurityConstants.EXPIRATION_TIME;
import static com.payday.iam.api.security.SecurityConstants.SECRET;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.payday.iam.api.models.v1.LoginRequestDto;
import com.payday.iam.api.models.v1.LoginResponseDto;
import com.payday.iam.api.models.v1.UserDto;
import com.payday.iam.application.services.IUserService;
import com.payday.iam.domain.models.User;


@RestController
@RequestMapping("api/v1/iam")
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
    private IUserService userService;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
    public UserDto signUp(@RequestBody UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));                     
        
        User user = convertToEntity(userDto);
         User createdUser = userService.SignUp(user);
        return convertToDto(createdUser);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) throws Exception {

		authenticate(loginRequestDto.getEmailAddress(), loginRequestDto.getPassword());

		final UserDetails userDetails = userService.loadUserByUsername(loginRequestDto.getEmailAddress());
		
		User user = userService.FindUserByEmailAddress(userDetails.getUsername());
		
		String token = JWT.create()
                .withSubject(user.getId().toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(HMAC512(SECRET.getBytes()));

		

		return ResponseEntity.ok(new LoginResponseDto(token));
	}
    
    private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
    
	private UserDto convertToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);	    
	    return userDto;
	}
	
	private User convertToEntity(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);	    
	    return user;
	}
    
    
}