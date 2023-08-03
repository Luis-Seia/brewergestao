package com.seia.brewergestao.Controller;

import com.seia.brewergestao.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsuarioController {

    @RequestMapping("usuarios/novo")
    public String novo(Model model){
        model.addAttribute(new Usuario());
        return "usuario/CadastroUsuario";
    }
}
