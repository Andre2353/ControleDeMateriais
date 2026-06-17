package com.biolab.controledemateriasis.Controller;

import com.biolab.controledemateriasis.Repository.CategoriasRepository;
import com.biolab.controledemateriasis.entities.Categorias;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class Categoriascontroller {
    private final CategoriasRepository categoriasRepository;

    public Categoriascontroller(CategoriasRepository categoriacontroller) {
        this.categoriasRepository = categoriacontroller;
    }

    @PostMapping("/cadastrar")
    public String cadastrarCategoria(@RequestBody Categorias categorias) {
        categoriasRepository.save(categorias);
        return "cadastrado com sucesso";
    }
    @GetMapping("/Listar")
    public List<Categorias> listarTodos() {
        return categoriasRepository.findAll();
    }

}

