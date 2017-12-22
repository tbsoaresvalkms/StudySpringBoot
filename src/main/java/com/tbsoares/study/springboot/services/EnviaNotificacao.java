package com.tbsoares.study.springboot.services;

import com.tbsoares.study.springboot.models.Cliente;
import com.tbsoares.study.springboot.models.Pedido;
import org.springframework.stereotype.Component;

@Component
public class EnviaNotificacao {
    private Notificacao notificacao;

    public EnviaNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
    }

    public void enviaEmail(Cliente cliente, Pedido pedido){
        if(notificacao.envioAtivo()){
            System.out.println("Enviado");
        }else{
            System.out.println("Nao enviado");
        }
    }
}
