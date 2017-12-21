package com.tbsoares.study.springboot.controllers;

import com.tbsoares.study.springboot.models.Cliente;
import com.tbsoares.study.springboot.models.Item;
import com.tbsoares.study.springboot.models.Pedido;
import com.tbsoares.study.springboot.models.RespostaDTO;
import com.tbsoares.study.springboot.repositories.ClienteRepository;
import com.tbsoares.study.springboot.repositories.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class NovoPedidoController {

    private ClienteRepository clienteRepository;
    private ItemRepository itemRepository;

    public NovoPedidoController(ClienteRepository clienteRepository, ItemRepository itemRepository) {
        this.clienteRepository = clienteRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/rest/pedido/novo/{clienteId}/{listaDeItens}")
    public RespostaDTO novo(@PathVariable("clienteId") Long clienteId, @PathVariable("listaDeItens") String listaDeItens) {
        RespostaDTO dto = new RespostaDTO();
        try {
            Cliente c = clienteRepository.findOne(clienteId);
            String[] listaDeItensID = listaDeItens.split(",");
            Pedido pedido = new Pedido();
            Double valorTotal = 0d;
            List<Item> itensPedidos = new ArrayList<Item>();
            for (String itemId : listaDeItensID) {
                Item item = itemRepository.findOne(Long.parseLong(itemId));
                itensPedidos.add(item);
                valorTotal += item.getPreco();
            }
            pedido.setItems(itensPedidos);
            pedido.setValorTotal(valorTotal);
            pedido.setData(LocalDate.now());
            pedido.setCliente(c);
            c.getPedidos().add(pedido);
            this.clienteRepository.saveAndFlush(c);
            List<Long> pedidosID = new ArrayList<Long>();

            for (Pedido p : c.getPedidos()) pedidosID.add(p.getId());

            Long ultimoPedido = Collections.max(pedidosID);
            dto = new RespostaDTO(valorTotal, ultimoPedido, "Pedido efetuado com sucesso");
        } catch (Exception e) {
            dto.setMensagem("Erro: " + e.getMessage());
        }
        return dto;
    }
}
