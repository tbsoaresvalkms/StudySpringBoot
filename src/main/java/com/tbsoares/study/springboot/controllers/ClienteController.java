package com.tbsoares.study.springboot.controllers;

import com.tbsoares.study.springboot.models.Cliente;
import com.tbsoares.study.springboot.repositories.ClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final String CLIENTE_URI = "clientes/";

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping()
    public ModelAndView list() {
        Iterable<Cliente> clientes = this.clienteRepository.findAll();
        return new ModelAndView("clientes/list", "clientes", clientes);
    }

    @GetMapping("{id}")
    public ModelAndView show(@PathVariable("id") Cliente cliente) {
        ModelAndView modelAndView = getModelAndView("clientes/view");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @GetMapping("/novo")
    public String createForm(@ModelAttribute Cliente cliente) {
        return "clientes/form";
    }

    @PostMapping(params = "form")
    public ModelAndView create(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = getModelAndView(CLIENTE_URI + "form");
            modelAndView.addObject("formErros", result.getAllErrors());
            return modelAndView;
        }
        cliente = this.clienteRepository.save(cliente);
        redirect.addFlashAttribute("globalMessage", "Cliente gravado com sucesso");
        ModelAndView modelAndView = getModelAndView("redirect:/" + CLIENTE_URI + "{cliente.id}");
        modelAndView.addObject("cliente.id", cliente.getId());
        return modelAndView;
    }

    @GetMapping(value = "alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Cliente cliente) {
        ModelAndView modelAndView = getModelAndView("clientes/form");
        modelAndView.addObject("cliente", cliente);
        return modelAndView;
    }

    @GetMapping(value = "remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
        this.clienteRepository.delete(id);
        redirect.addFlashAttribute("globalMessage", "Cliente removido com sucesso");
        return getModelAndView("redirect:/" + CLIENTE_URI);
    }

    private ModelAndView getModelAndView(String view) {
        return new ModelAndView(view);
    }
}
