package com.canteen.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.canteen.entity.UserDtls;



public interface UserRepository extends JpaRepository<UserDtls,Integer > {
	public UserDtls findByEmail(String email);

}
