package com.supermercado.estoque1.service;

import com.supermercado.estoque1.model.ProdutoModel;
import com.supermercado.estoque1.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoModel cadastraProduto(ProdutoModel produtoModel){

        return produtoRepository.save(produtoModel);

    }

    public List<ProdutoModel> buscarProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {

        return produtoRepository.findById(id);
    }

}

