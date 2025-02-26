package com.primeira.appSpring.repository;
import com.primeira.appSpring.model.M_API; // Se M_API for o modelo esperado, ok, caso contrário ajuste o tipo de retorno
import com.primeira.appSpring.model.M_Consumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface R_API extends JpaRepository<M_API, Long> {

    @Query(value = "WITH vendas_produto AS (" +
            "    SELECT " +
            "        id_produto, " +
            "        sum(quantidade) AS quantidade, " +
            "        sum(quantidade * preco) / sum(quantidade) AS preco_medio_venda " +
            "    FROM consumo " +
            "    WHERE data <= :data_base " + // Usando o parâmetro data_base corretamente
            "    GROUP BY id_produto " +
            "), " +
            "compras_produto AS (" +
            "    SELECT " +
            "        id_produto, " +
            "        sum(quantidade) AS quantidade " +
            "    FROM compra " +
            "    WHERE data <= :data_base " + // Também filtra compras até a data informada
            "    GROUP BY id_produto " +
            ") " +
            "SELECT " +
            "    vp.id_produto, " +
            "    COALESCE(cp.quantidade, 0) - COALESCE(vp.quantidade, 0) AS saldo, " +
            "    vp.preco_medio_venda " +
            "FROM vendas_produto vp " +
            "LEFT JOIN compras_produto cp " +
            "    ON vp.id_produto = cp.id_produto",
            nativeQuery = true)
    List<M_API> getSaldoProduto(@Param("data_base") LocalDate data);
}
