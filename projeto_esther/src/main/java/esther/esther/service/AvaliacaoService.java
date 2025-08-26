package esther.esther.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esther.esther.model.Avaliacao;
import esther.esther.repository.AvaliacaoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AvaliacaoService {

    @Autowired
    private final AvaliacaoRepository avaliacaoRepository;

    AvaliacaoService(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    public List<Avaliacao> buscarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao buscarPorId(Integer id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Avaliação não encontrado com ID:" + id));
    }

    public Avaliacao salvarAvaliacao(Avaliacao avaliacao) {
        return avaliacaoRepository.save(avaliacao);
    }

}
