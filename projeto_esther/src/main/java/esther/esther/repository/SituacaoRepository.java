package esther.esther.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esther.esther.model.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Integer>{
    
}
