package com.tbsoares.study.springboot.configurations;

import com.tbsoares.study.springboot.models.Cliente;
import com.tbsoares.study.springboot.models.Item;
import com.tbsoares.study.springboot.models.Pedido;
import com.tbsoares.study.springboot.repositories.ClienteRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Item.class, Pedido.class, Cliente.class);
    }
}
