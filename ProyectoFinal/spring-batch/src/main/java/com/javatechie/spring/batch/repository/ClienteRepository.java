package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente,Integer> {
}
