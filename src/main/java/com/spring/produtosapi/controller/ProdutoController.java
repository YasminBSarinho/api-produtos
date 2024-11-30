package com.spring.produtosapi.controller;

import com.spring.produtosapi.model.Produto;
import com.spring.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto Recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        System.out.println("Produto Recebido: " + produto);

        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
        System.out.println("Produto Deletado: " + id);
    }

    @PutMapping("/{id}")
    public void Atualizar(@PathVariable("id") String id,@RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome){
        return produtoRepository.findByNome(nome);
    }
}
