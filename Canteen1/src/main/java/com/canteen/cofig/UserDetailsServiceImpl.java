package com.canteen.cofig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.canteen.entity.UserDtls;
import com.canteen.repository.UserRepository;



public class UserDetailsServiceImpl {

	@Autowired
	private UserRepository userRepo;
	
	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDtls user=userRepo.findByEmail(username);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("User Not Exist");
		}
		return null;
			
		
	}

}