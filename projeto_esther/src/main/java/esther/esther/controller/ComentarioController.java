package esther.esther.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import esther.esther.model.Comentario;
import esther.esther.service.ComentarioService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public String listarComentarios(Model model) {
        model.addAttribute("comentarios", comentarioService.buscarComentarios());
        return "comentario/lista";
    }
    
    @GetMapping("/adicionar")
    public String exibirFormulario() {
        return "comentario/formulario";
    }
    
    @PostMapping
    public String salvarComentario(@ModelAttribute Comentario comentario, RedirectAttributes redirectAttributes) {
        try {
            comentarioService.salvarComentario(comentario);
            redirectAttributes.addFlashAttribute("sucesso", "Comentário salvo com sucesso!");
            return "redirect:/comentario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar o comentário: " + e.getMessage());
            return "comentario/form";
        }
    }
    
    
}
