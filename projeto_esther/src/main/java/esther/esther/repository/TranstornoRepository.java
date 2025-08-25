package esther.esther.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import esther.esther.model.Transtorno;

@Repository
public interface TranstornoRepository extends JpaRepository<Transtorno, Integer>{
    
}

