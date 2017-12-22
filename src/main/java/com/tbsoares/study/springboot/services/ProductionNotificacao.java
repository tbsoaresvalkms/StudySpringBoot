package com.tbsoares.study.springboot.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("production")
public class ProductionNotificacao implements Notificacao {
    @Override
    public boolean envioAtivo() {
        return true;
    }
}
