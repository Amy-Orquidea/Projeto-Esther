package esther.esther.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esther.esther.model.Usuario;
import esther.esther.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;
    
    public UsuarioService(UsuarioRepository usuarioRepository) {
    this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> buscarComentarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID:" + id));
    }

    public Usuario salvarComentario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public void excluirComentarioPorId(Integer id){
        if (!usuarioRepository.existsById(id)){
            throw new EntityNotFoundException("Comentário não encontrado com ID:" + id);
        }else{
            usuarioRepository.deleteById(id);
        }
    }
}
