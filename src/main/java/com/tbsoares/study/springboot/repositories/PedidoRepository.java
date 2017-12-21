package com.tbsoares.study.springboot.repositories;

import com.tbsoares.study.springboot.models.Cliente;
import com.tbsoares.study.springboot.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pedidos", path = "pedidos")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
