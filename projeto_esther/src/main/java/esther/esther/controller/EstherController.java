package esther.esther.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import esther.esther.model.Avaliacao;
import esther.esther.service.AvaliacaoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping
    public String avaliacaoForm(@ModelAttribute Avaliacao ava, RedirectAttributes redirectAttributes) {
        try {
            avaliacaoService.salvarAvaliacao(ava);
            redirectAttributes.addFlashAttribute("sucesso", "avaliação salvo com sucesso!");
            return "redirect:/";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar a avaliação: " + e.getMessage());
            return "esther/avaliacao";
        }
    }

    @GetMapping("/avaliacoesAdm")
    public String listaAvaliacoesAdm(Model model) {
        model.addAttribute("avaliacoes", avaliacaoService.buscarAvaliacoes());
        return "esther/avaliacaoAdm";
    }
}
