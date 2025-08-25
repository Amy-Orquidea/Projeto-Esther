package esther.esther.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esther.esther.model.Deficiencia;
import esther.esther.repository.DeficienciaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DeficienciaService {

    @Autowired
    private final DeficienciaRepository deficienciaRepository;
    
    public DeficienciaService(DeficienciaRepository deficienciaRepository) {
    this.deficienciaRepository = deficienciaRepository;
    }

    public List<Deficiencia> buscarComentarios() {
        return deficienciaRepository.findAll();
    }

    public Deficiencia buscarPorId(Integer id) {
        return deficienciaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comentário não encontrado com ID:" + id));
    }

    public Deficiencia salvarComentario(Deficiencia deficiencia){
        return deficienciaRepository.save(deficiencia);
    }

    public void excluirComentarioPorId(Integer id){
        if (!deficienciaRepository.existsById(id)){
            throw new EntityNotFoundException("Comentário não encontrado com ID:" + id);
        }else{
            deficienciaRepository.deleteById(id);
        }
    }
}
