package com.seia.brewergestao.Controller;


import com.seia.brewergestao.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClienteController {

    @RequestMapping("/clientes/novo")
    public String novo(Model model){
        model.addAttribute(new Cliente());
        return "cliente/CadastroCliente";
    }
}
