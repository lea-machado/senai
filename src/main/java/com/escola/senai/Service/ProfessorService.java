package com.escola.senai.Service;

import com.escola.senai.Interface.AlunoRepository;
import com.escola.senai.Model.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository; //representa a imutabilidade para um serviço

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listarTodosAlunos() {
        return repository.findAll();
    }

    public Aluno criarAluno(Aluno aluno) {
        return repository.save(aluno);
    }

    public void deletarAluno(Long id){
        repository.deleteById(id);
    }

    public Aluno buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
}
