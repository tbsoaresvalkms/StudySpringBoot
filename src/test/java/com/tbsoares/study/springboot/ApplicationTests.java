package com.tbsoares.study.springboot;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void testHome() throws Exception {
        String URL1 = "/api";
        System.out.println(this.mvc.perform(get(URL1)).andDo(print()));
        this.mvc.perform(get(URL1))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("pedidos")));
    }

    @Test
    public void findItem2() throws Exception {
        String URL5 = "/api/itens/2";
        System.out.println(this.mvc.perform(get(URL5)).andDo(print()));
        this.mvc.perform(
                get(URL5))
                .andExpect(status().isOk())
                .andExpect(jsonPath("preco", equalTo(30.0)));
    }

    @Test
    public void cadastraNovoPedido() throws Exception {
        String URL4 = "/rest/pedido/novo/1/1,2";
        System.out.println(this.mvc.perform(get(URL4))
                .andDo(print()));
        this.mvc.perform(
                get(URL4))
                .andExpect(status().isOk())
                .andExpect(jsonPath("valorTotal", is(57.0)))
                .andExpect(jsonPath("pedido", greaterThan(3)))
                .andExpect(jsonPath("mensagem", equalTo("Pedido efetuado com sucesso")));
    }

    @Test
    public void atualizarCliente() throws Exception {
        String URL6 = "/clientes/alterar/1";
        System.out.println(this.mvc.perform(get(URL6))
                .andDo(print()));
        this.mvc.perform(
                get(URL6))
                .andExpect(status().isOk())
                .andExpect(view().name("clientes/form"));
    }
}
