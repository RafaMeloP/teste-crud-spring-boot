package com.example.demo.service;

import com.example.demo.entity.Pessoa;

import java.util.List;

public interface PessoaService {
    public Pessoa savePessoa(Pessoa pessoa);

    public List<Pessoa> getPessoas();

    public Pessoa getPessoaById(Long id);

    public Pessoa getPessoaByName(String nome);

    public Pessoa editPessoa(Long id, Pessoa pessoa);

    public String deletePessoa(Long id);
}
