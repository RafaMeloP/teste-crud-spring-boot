package com.example.demo.service;

import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServiceImpl implements PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa savePessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public List<Pessoa> getPessoas() {
        return pessoaRepository.findAll();
    }

    @Override
    public Pessoa getPessoaById(Long id) {
        return pessoaRepository.findById(id).get();
    }

    @Override
    public Pessoa getPessoaByName(String nome) {
        return pessoaRepository.findPessoaByNomeIgnoreCase(nome);
    }

    @Override
    public Pessoa editPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaDb = pessoaRepository.findById(id).get();

        if(pessoa.getNome() == null || "".equalsIgnoreCase(pessoa.getNome())){
            pessoa.setNome(pessoaDb.getNome());
        }
        if(pessoa.getBairro() == null || "".equalsIgnoreCase(pessoa.getBairro())){
            pessoa.setBairro(pessoaDb.getBairro());
        }
        if(pessoa.getLogradouro() == null || "".equalsIgnoreCase(pessoa.getLogradouro())){
            pessoa.setLogradouro(pessoaDb.getLogradouro());
        }
        if(pessoa.getUf() == null || "".equalsIgnoreCase(pessoa.getUf())){
            pessoa.setUf(pessoaDb.getUf());
        }

        pessoa.setId(pessoaDb.getId());

        return pessoaRepository.save(pessoa);
    }

    @Override
    public String deletePessoa(Long id) {
        pessoaRepository.deleteById(id);
        return "Registro excluído com sucesso";
    }
}
