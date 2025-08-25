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

import esther.esther.model.Deficiencia;
import esther.esther.service.DeficienciaService;

@Controller
@RequestMapping("/def")
public class DeficienciaController {

    @Autowired
    private final DeficienciaService deficienciaService;

    public DeficienciaController(DeficienciaService deficienciaService) {
        this.deficienciaService = deficienciaService;
    }

    @GetMapping("/adm")
    public String listarComentariosAdm(Model model) {
        model.addAttribute("deficiencias", deficienciaService.buscarComentarios());
        return "deficiencia/listaAdm";
    }

    @GetMapping("/comentario")
    public String exibirFormulario(Model model) {
        model.addAttribute("deficiencias", deficienciaService.buscarComentarios());
        return "deficiencia/comentario";
    }

    @PostMapping
    public String salvarComentario(@ModelAttribute Deficiencia def, RedirectAttributes redirectAttributes) {
        try {
            deficienciaService.salvarComentario(def);
            redirectAttributes.addFlashAttribute("sucesso", "Comentário salvo com sucesso!");
            return "redirect:/def/comentario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar o comentário: " + e.getMessage());
            return "deficiencia/comentario";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarComentario(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            deficienciaService.excluirComentarioPorId(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Comentário Deletado!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao excluir comentário " + e.getMessage());
        }
        return "redirect:/def/adm";
    }

}
