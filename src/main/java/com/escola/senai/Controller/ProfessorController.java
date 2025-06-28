package com.escola.senai.Controller;

import com.escola.senai.Model.Aluno;
import com.escola.senai.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listarAlunos(){
        return service.listarTodosAlunos();
    }

    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno novoAluno){
        return service.criarAluno(novoAluno);
    }

    @GetMapping("/{id}")
    public Aluno buscarAluno(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado){
        Aluno alunoExistente = service.buscarPorId(id);
        if (alunoExistente == null) return null;

        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setEmail(alunoAtualizado.getEmail());
        alunoExistente.setTelefone(alunoAtualizado.getTelefone());
        return service.criarAluno(alunoExistente);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id){
        service.deletarAluno(id);
    }
}
