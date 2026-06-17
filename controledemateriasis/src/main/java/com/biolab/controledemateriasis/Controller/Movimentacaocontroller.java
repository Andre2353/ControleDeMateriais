package com.biolab.controledemateriasis.Controller;

import com.biolab.controledemateriasis.Repository.Movimentacaorepository;
import com.biolab.controledemateriasis.entities.Movimentacao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class Movimentacaocontroller {
    private final Movimentacaorepository movimentacaorepository;

    public Movimentacaocontroller(Movimentacaorepository movimentacaorepository) {
        this.movimentacaorepository = movimentacaorepository;
    }
    @PostMapping("/cadastrar")
    public String cadastrarmovimentacao(@RequestBody Movimentacao movimentacao) {
        movimentacaorepository.save(movimentacao);
        return "cadastrado com sucesso";
    }
    @GetMapping("/listar")
    public List<Movimentacao> listartodos(){
        return movimentacaorepository.findAll();
    }

}
