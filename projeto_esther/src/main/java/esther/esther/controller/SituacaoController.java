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

import esther.esther.model.Situacao;
import esther.esther.service.SituacaoService;

@Controller
@RequestMapping("/sit")
public class SituacaoController {

    @Autowired
    private final SituacaoService situacaoService;

    public SituacaoController(SituacaoService situacaoService) {
        this.situacaoService = situacaoService;
    }

    @GetMapping("/info")
    public String informacoes() {
        return "situacao/info";
    }

    @GetMapping("/adm")
    public String listarComentariosAdm(Model model) {
        model.addAttribute("situacoes", situacaoService.buscarComentarios());
        return "situacao/listaAdm";
    }

    @GetMapping("/comentario")
    public String exibirFormulario(Model model) {
        model.addAttribute("situacoes", situacaoService.buscarComentarios());
        return "situacao/comentario";
    }

    @PostMapping
    public String salvarComentario(@ModelAttribute Situacao sit, RedirectAttributes redirectAttributes) {
        try {
            situacaoService.salvarComentario(sit);
            redirectAttributes.addFlashAttribute("sucesso", "Comentário salvo com sucesso!");
            return "redirect:/sit/comentario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar o comentário: " + e.getMessage());
            return "situacao/comentario";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarComentario(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            situacaoService.excluirComentarioPorId(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Comentário Deletado!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao excluir comentário " + e.getMessage());
        }
        return "redirect:/sit/adm";
    }

}
