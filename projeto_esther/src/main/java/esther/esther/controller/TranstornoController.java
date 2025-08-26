package esther.esther.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import esther.esther.model.Transtorno;
import esther.esther.service.TranstornoService;

@Controller
@RequestMapping("/trans")
public class TranstornoController {
    @Autowired
    private final TranstornoService transtornoService;

    public TranstornoController(TranstornoService transtornoService) {
        this.transtornoService = transtornoService;
    }

    @GetMapping("/info")
    public String informacoes() {
        return "transtorno/info";
    }

    @GetMapping("/adm")
    public String listarComentariosAdm(Model model) {
        model.addAttribute("transtornos", transtornoService.buscarComentarios());
        return "transtorno/listaAdm";
    }

    @GetMapping("/comentario")
    public String exibirFormulario(Model model) {
        model.addAttribute("transtornos", transtornoService.buscarComentarios());
        return "transtorno/comentario";
    }

    @PostMapping
    public String salvarComentario(@ModelAttribute Transtorno trans, RedirectAttributes redirectAttributes) {
        try {
            transtornoService.salvarComentario(trans);
            redirectAttributes.addFlashAttribute("sucesso", "Comentário salvo com sucesso!");
            return "redirect:/trans/comentario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar o comentário: " + e.getMessage());
            return "transtorno/comentario";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarComentario(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            transtornoService.excluirComentarioPorId(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Comentário Deletado!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao excluir comentário " + e.getMessage());
        }
        return "redirect:/trans/adm";
    }
}
