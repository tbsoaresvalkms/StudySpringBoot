package com.tbsoares.study.springboot.repositories;

import com.tbsoares.study.springboot.models.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteRepositoryTest {
    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void buscaClientesCadastrados() {
        Page<Cliente> clientes = this.clienteRepository.findAll(new PageRequest(0, 10));
        assertThat(clientes.getTotalElements()).isGreaterThan(1L);
    }

    @Test
    public void buscaClienteFernando() {
        Cliente clienteNaoEncontrado = this.clienteRepository.findByNome("Fernando");
        assertThat(clienteNaoEncontrado).isNull();
        Cliente cliente = this.clienteRepository.findByNome("Fernando Boaglio");
        assertThat(cliente).isNotNull();
        assertThat(cliente.getNome()).isEqualTo("Fernando Boaglio");
        assertThat(cliente.getEndereco()).isEqualTo("Sampa");
    }
}
