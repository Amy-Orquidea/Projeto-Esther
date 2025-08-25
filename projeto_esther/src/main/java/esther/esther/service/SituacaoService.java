package esther.esther.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import esther.esther.model.Situacao;
import esther.esther.repository.SituacaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SituacaoService {

    @Autowired
    private final SituacaoRepository situacaoRepository;

    public SituacaoService(SituacaoRepository situacaoRepository) {
    this.situacaoRepository = situacaoRepository;
    }

    public List<Situacao> buscarComentarios() {
        return situacaoRepository.findAll();
    }

    public Situacao buscarPorId(Integer id) {
        return situacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID:" + id));
    }

    public Situacao salvarComentario(Situacao situacao) {
        return situacaoRepository.save(situacao);
    }

    public void excluirComentarioPorId(Integer id) {
        if (!situacaoRepository.existsById(id)) {
            throw new EntityNotFoundException("Comentário não encontrado com ID:" + id);
        } else {
            situacaoRepository.deleteById(id);
        }
    }

}