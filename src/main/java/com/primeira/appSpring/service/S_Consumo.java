package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Consumo;
import com.primeira.appSpring.model.M_Locacao;
import com.primeira.appSpring.model.M_Produto;
import com.primeira.appSpring.repository.R_Consumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class S_Consumo {
    @Autowired
    private R_Consumo r_consumo;
    @Autowired
    private S_Produto s_produto;

    public M_Consumo salvarConsumo(Long idProduto, Long idLocacao, Integer quantidade){
        M_Produto m_produto = s_produto.getProdutoById(idProduto);
        M_Locacao m_locacao = new M_Locacao(idLocacao);

        M_Consumo m_consumo = new M_Consumo();
        m_consumo.setData(LocalDateTime.now());
        m_consumo.setLocacao(m_locacao);
        m_consumo.setProduto(m_produto);
        m_consumo.setPreco(m_produto.getPreco());
        m_consumo.setQuantidade(quantidade);

        return r_consumo.save(m_consumo);
    }

    public List<M_Consumo> getConsumos(Long idLocacao){
        return r_consumo.getConsumosByLocacao(idLocacao);
    }
}
