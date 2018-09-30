/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.springboot.SpringBootBase.repository;

import com.in28minutes.springboot.SpringBootBase.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository{ // extends JpaRepository<User,Integer>{
    // This may be causing the issue since it is not actually hitting a repository
}

