package com.primeira.appSpring.repository;

import com.primeira.appSpring.model.M_Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface R_Locacao extends JpaRepository<M_Locacao, Long> {
    @Query(value = "select * " +
            "from locacao " +
            "where locacao.id_quarto = :id_quarto " +
            "and (locacao.check_in between :check_in and :check_out " +
            "or :check_in between locacao.check_in and locacao.check_out " +
            "or :check_out between locacao.check_in and locacao.check_out) " +
            "limit 1",nativeQuery = true)
    M_Locacao quartoEstaLocado(@Param("id_quarto") Long id,
                                        @Param("check_in") LocalDateTime check_in,
                                        @Param("check_out") LocalDateTime check_out);

    @Query(value="select * " +
            "from locacao " +
            "where locacao.id_usuario = :id_usuario " +
            "and now() between locacao.check_in and locacao.check_out",
            nativeQuery = true)
    List<M_Locacao> getLocacoesEmCurso(@Param("id_usuario") Long id_usuario);
}
