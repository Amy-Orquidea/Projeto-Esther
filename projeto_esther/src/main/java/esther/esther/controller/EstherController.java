package esther.esther.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/esther")
public class EstherController {

    @GetMapping("/transtorno")
    public String transtornos() {
        // return "esther/transtorno";
        return "erro";
    }

    @GetMapping("/deficiencias")
    public String deficiencia() {
        // return "esther/deficiencia";
        return "erro";
    }

    @GetMapping("/situacoes")
    public String situacao() {
        // return "esther/situacao";
        return "erro";
    }
    
    
    
    
}
