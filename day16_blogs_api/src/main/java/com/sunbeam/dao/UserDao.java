package com.sunbeam.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sunbeam.dto.AddressDto;
import com.sunbeam.dto.UserRespDTO;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.User;

public interface UserDao extends JpaRepository<User,Long>{
//add derived finder method for user signin 
	Optional<User> findByEmailAndPassword(String email,String pass);
	//List<User> findByUserAddressCity();
	//@Query("select c from Category c left join fetch c.posts where c.id=:id")

	@Query("Select u from User u where u.userAddress.city=:city")
	List<User> getUserFromCity(String city);

}
