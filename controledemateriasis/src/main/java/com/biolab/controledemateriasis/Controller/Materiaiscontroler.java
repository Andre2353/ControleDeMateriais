package com.biolab.controledemateriasis.Controller;

import com.biolab.controledemateriasis.Repository.MateriaisRepository;
import com.biolab.controledemateriasis.entities.Materiais;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiais")
public class Materiaiscontroler {
    private final MateriaisRepository materiaisRepository;

    public Materiaiscontroler(MateriaisRepository materiaisRepository) {
        this.materiaisRepository = materiaisRepository;
    }

    @PostMapping("/cadastar")
    public String cadastrarMaterial(@RequestBody Materiais materiais) {
        materiaisRepository.save(materiais);
        return "cadastrado com sucesso";
    }

    @GetMapping("/Listar")
    public List<Materiais> listartodos() {
        return materiaisRepository.findAll();
    }


}

