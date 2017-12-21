package com.tbsoares.study.springboot.repositories;

import com.tbsoares.study.springboot.models.Cliente;
import com.tbsoares.study.springboot.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    Cliente findByNome(String nome);
}
