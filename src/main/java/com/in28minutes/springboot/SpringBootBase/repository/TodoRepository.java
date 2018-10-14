/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.in28minutes.springboot.SpringBootBase.repository;

import com.in28minutes.springboot.SpringBootBase.dao.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface TodoRepository extends JpaRepository<Todo,Integer>{
    
    List<Todo> findByUser(String user);
}

