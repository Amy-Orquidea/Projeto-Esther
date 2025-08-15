package esther.esther.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esther.esther.model.Deficiencia;

@Repository
public interface DeficienciaRepository extends JpaRepository<Deficiencia, Integer>{
    
}
