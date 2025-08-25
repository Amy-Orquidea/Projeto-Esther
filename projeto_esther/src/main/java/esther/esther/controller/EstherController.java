package esther.esther.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import esther.esther.service.AvaliacaoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/esther")
public class EstherController {

    @Autowired
    private final AvaliacaoService avaliacaoService;

    public EstherController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }

    @GetMapping("/transtornos")
    public String transtornos() {
        return "esther/transtorno";
        // return "erro";
    }

    @GetMapping("/deficiencias")
    public String deficiencia() {
        return "esther/deficiencia";
        // return "erro";
    }

    @GetMapping("/situacoes")
    public String situacao() {
        return "esther/situacao";
        // return "erro";
    }

    @GetMapping("/avaliacoes")
    public String avaliacao() {
        return "esther/avaliacao";
        // return "erro";
    }

    @PostMapping("/avaliacoes")
    public String avaliacaoForm(@RequestBody String entity) {

        return entity;
    }

}
