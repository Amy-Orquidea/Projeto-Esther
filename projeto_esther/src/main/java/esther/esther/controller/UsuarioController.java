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

import esther.esther.model.Usuario;
import esther.esther.service.UsuarioService;

@Controller
@RequestMapping("/comentario")
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public String listarComentarios(Model model) {
        model.addAttribute("usuarios", usuarioService.buscarComentarios());
        return "comentario/lista";
    }

    @GetMapping("/adm")
    public String listarComentariosAdm(Model model) {
        model.addAttribute("usuarios", usuarioService.buscarComentarios());
        return "comentario/listaAdm";
    }

    @GetMapping("/adicionar")
    public String exibirFormulario() {
        return "comentario/form";
    }

    @PostMapping
    public String salvarComentario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.salvarComentario(usuario);
            redirectAttributes.addFlashAttribute("sucesso", "Comentário salvo com sucesso!");
            return "redirect:/comentario";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", "Erro ao salvar o comentário: " + e.getMessage());
            return "comentario/form";
        }
    }

    @GetMapping("/deletar/{id}")
    public String deletarComentario(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        try {
            usuarioService.excluirComentarioPorId(id);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Comentário Deletado!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao excluir comentário " + e.getMessage());
        }
        return "redirect:/comentario/adm";
    }

}
