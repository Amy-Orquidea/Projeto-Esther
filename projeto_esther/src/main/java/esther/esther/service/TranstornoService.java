package esther.esther.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esther.esther.model.Transtorno;
import esther.esther.repository.TranstornoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class TranstornoService {
    @Autowired
    private final TranstornoRepository transtornoRepository;

    public TranstornoService(TranstornoRepository transtornoRepository) {
    this.transtornoRepository = transtornoRepository;
    }

    public List<Transtorno> buscarComentarios() {
        return transtornoRepository.findAll();
    }

    public Transtorno buscarPorId(Integer id) {
        return transtornoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID:" + id));
    }

    public Transtorno salvarComentario(Transtorno transtorno) {
        return transtornoRepository.save(transtorno);
    }

    public void excluirComentarioPorId(Integer id) {
        if (!transtornoRepository.existsById(id)) {
            throw new EntityNotFoundException("Comentário não encontrado com ID:" + id);
        } else {
            transtornoRepository.deleteById(id);
        }
    }
}
