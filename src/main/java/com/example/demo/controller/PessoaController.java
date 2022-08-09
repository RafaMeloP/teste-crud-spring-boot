package com.example.demo.controller;

import com.example.demo.entity.Pessoa;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/pessoa")
    public Pessoa savePessoa(@RequestBody Pessoa pessoa){
        return pessoaService.savePessoa(pessoa);
    }
    @GetMapping("/pessoa")
    public List<Pessoa> getPessoas(){
        return pessoaService.getPessoas();
    }
    @GetMapping("/pessoa/{id}")
    public Pessoa getPessoaById(@PathVariable Long id){
        return pessoaService.getPessoaById(id);
    }
    @GetMapping("/pessoa/nome/{nome}")
    public Pessoa getPessoaByName(@PathVariable String nome){
        return pessoaService.getPessoaByName(nome);
    }
    @PutMapping("/pessoa/{id}")
    public Pessoa editPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        return pessoaService.editPessoa(id, pessoa);
    }
    @DeleteMapping("/pessoa/{id}")
    public String deletePessoa(@PathVariable Long id){
        return pessoaService.deletePessoa(id);
    }
}
