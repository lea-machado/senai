package com.escola.senai.Service;

import com.escola.senai.Interface.ProfessorRepository;
import com.escola.senai.Model.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository; //representa a imutabilidade para um serviço

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public List<Professor> listarTodosProfessores() {
        return repository.findAll();
    }

    public Professor criarProfessor(Professor professor) {
        return repository.save(professor);
    }

    public void deletarProfessor(Long id){
        repository.deleteById(id);
    }

    public Professor buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
}
