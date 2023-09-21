package com.supermercado.estoque1.controller;

import com.supermercado.estoque1.model.ProdutoModel;
import com.supermercado.estoque1.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin(origins = "http://127.0.0.1:3000")
    public ResponseEntity<ProdutoModel> cadastraProduto(@RequestBody ProdutoModel produtoModel){
        return ResponseEntity.ok(produtoService.cadastraProduto(produtoModel));
    }

    @CrossOrigin(origins = "http://127.0.0.1:3000")
    @GetMapping
    public ResponseEntity<List<ProdutoModel>>buscarTudo(){
        return ResponseEntity.ok(produtoService.buscarProdutos());
    }

    @CrossOrigin(origins = "http://127.0.0.1:3000")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ProdutoModel> buscarPorId(@PathVariable Long id){

        Optional<ProdutoModel> produtoModel = produtoService.buscarPorId(id);

        if (produtoModel.isPresent()){

            return ResponseEntity.ok(produtoModel.get());

        }else{
            return ResponseEntity.notFound().build();
        }

    }


}

