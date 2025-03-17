package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_API;
import com.primeira.appSpring.model.M_Produto;
import com.primeira.appSpring.repository.R_Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Produto {
    @Autowired
    private R_Produto r_produto;

    public List<M_Produto> getProdutos(){
        return r_produto.findAll();
    }

    public M_Produto getProdutoById(Long id){
        return (M_Produto) r_produto.getReferenceById(id);
    }
}
