package com.primeira.appSpring.repository;

import com.primeira.appSpring.model.M_Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Consumo extends JpaRepository<M_Consumo, Long> {
    @Query(value = "select * from consumo where id_locacao = :id_locacao order by data desc",nativeQuery = true)
    List<M_Consumo> getConsumosByLocacao(@Param("id_locacao") Long idLocacao);
}
