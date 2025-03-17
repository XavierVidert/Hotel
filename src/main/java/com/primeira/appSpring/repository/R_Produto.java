package com.primeira.appSpring.repository;

import com.primeira.appSpring.model.M_API;
import com.primeira.appSpring.model.M_Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface R_Produto {

    @Query(value = "WITH vendas_produto AS (" +
            "    SELECT " +
            "        id_produto, " +
            "        sum(quantidade) AS quantidade, " +
            "        sum(quantidade * preco) / sum(quantidade) AS preco_medio_venda " +
            "    FROM consumo " +
            "    WHERE data <= :data_base " +
            "    GROUP BY id_produto " +
            "), " +
            "compras_produto AS (" +
            "    SELECT " +
            "        id_produto, " +
            "        sum(quantidade) AS quantidade, " +
            "        MAX(data) AS ultima_compra " +
            "    FROM compra " +
            "    WHERE data <= :data_base " +
            "    GROUP BY id_produto " +
            ") " +
            "SELECT " +
            "    vp.id_produto AS id, " +
            "    COALESCE(cp.quantidade, 0) - COALESCE(vp.quantidade, 0) AS saldo, " +
            "    vp.preco_medio_venda AS custo_medio, " +
            "    10 AS min, " +
            "    100 AS max, " +
            "    p.nome AS nome_produto, " +
            "    cp.ultima_compra AS ultima_compra " +
            "FROM vendas_produto vp " +
            "LEFT JOIN compras_produto cp " +
            "    ON vp.id_produto = cp.id_produto " +
            "LEFT JOIN produto p " +
            "    ON CAST(p.cod_barras AS bigint) = vp.id_produto", nativeQuery = true)

    List<M_API> getSaldoProduto(@Param("data_base") LocalDate dataBase);
    @Query("SELECT FROM M_Produto p")
    List<M_Produto> findAll();

    @Query("SELECT FROM M_Produto p WHERE p.id = :id")
    M_Produto getReferenceById(@Param("id") Long id);
}
