package esther.esther.service;

import java.util.List;

import org.springframework.stereotype.Service;

import esther.esther.model.Comentario;
import esther.esther.repository.ComentarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ComentarioService {

    private ComentarioRepository comentarioRepository;

    public List<Comentario> buscarComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario buscarPorId(Integer id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID:" + id));
    }

    public Comentario salvarComentario(Comentario comentario){
        return comentarioRepository.save(comentario);
    }

    public void excluirComentarioPorId(Integer id){
        if (!comentarioRepository.existsById(id)){
            throw new EntityNotFoundException("Comentário não encontrado com ID:" + id);
        }else{
            comentarioRepository.deleteById(id);
        }
    }
}
