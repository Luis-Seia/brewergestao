package com.seia.brewergestao.Controller;

import com.seia.brewergestao.model.Cerveja;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CervejasController {

    @RequestMapping("/cervejas/novo")
    public String novo(Model model)
    {
        model.addAttribute(new Cerveja());
        return "cerveja/CadastroCerveja";
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes){
        if (result.hasErrors()){
            model.addAttribute(cerveja);
            return "cerveja/CadastroCerveja";
        }

        attributes.addFlashAttribute("mensagem", "funcionou");
        System.out.println("cadastraer" +cerveja.getSku());
        return "redirect:/cervejas/novo";
    }
    @RequestMapping("/cervejas/cadastro")
    public String cadastro(){
        return "cerveja/cadastro-produto";
    }
}
