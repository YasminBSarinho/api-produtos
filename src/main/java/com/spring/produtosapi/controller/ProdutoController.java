package com.spring.produtosapi.controller;

import com.spring.produtosapi.model.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto Recebido: " + produto);
        return produto;
    }
}
