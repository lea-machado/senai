package com.escola.senai.Controller;

import com.escola.senai.Model.Professor;
import com.escola.senai.Service.ProfessorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService service;

    public ProfessorController(ProfessorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Professor> listarProfessores(){
        return service.listarTodosProfessores();
    }

    @PostMapping
    public Professor criarProfessor(@RequestBody Professor novoProfessor){
        return service.criarProfessor(novoProfessor);
    }

    @GetMapping("/{id}")
    public Professor buscarProfessor(@PathVariable Long id){
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessor(@PathVariable Long id, @RequestBody Professor professorAtualizado){
        Professor professorExistente = service.buscarPorId(id);
        if (professorExistente == null) return null;

        professorExistente.setNome(professorAtualizado.getNome());
        professorExistente.setEmail(professorAtualizado.getEmail());
        professorExistente.setTelefone(professorAtualizado.getTelefone());
        return service.criarProfessor(professorExistente);
    }

    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable Long id){
        service.deletarProfessor(id);
    }
}
