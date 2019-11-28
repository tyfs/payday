package com.payday.iam.api.controllers.v1;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.payday.iam.api.models.v1.UserDto;
import com.payday.iam.application.services.IUserService;
import com.payday.iam.domain.models.User;


@RestController
@RequestMapping("api/v1/iam/users")
public class UserController {


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
    
	private UserDto convertToDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);	    
	    return userDto;
	}
	
	private User convertToEntity(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);	    
	    return user;
	}
    
    
}