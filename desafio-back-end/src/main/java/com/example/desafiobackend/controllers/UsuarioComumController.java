package com.example.desafiobackend.controllers;

import com.example.desafiobackend.domain.usuario.RequestUsuarioComum;
import com.example.desafiobackend.domain.usuario.UsuarioComum;
import com.example.desafiobackend.domain.usuario.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/usuariocomum")
public class UsuarioComumController {

    @Autowired
    private UsuarioRepository repository;


    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable String id){
        Optional<UsuarioComum> getSaldoById = repository.findById(id);
        return ResponseEntity.ok().body(getSaldoById);
    }

  @GetMapping
  public ResponseEntity<List<UsuarioComum>> getSaldo(@RequestBody Map<String,Integer> body) {
      Integer saldo = body.get("saldo");
      List<UsuarioComum> getSaldoById = repository.findBySaldo(saldo);
      return ResponseEntity.ok().body(getSaldoById);
  }

    @PostMapping
    public ResponseEntity addUsuarioComum(@RequestBody @Valid RequestUsuarioComum data){
        UsuarioComum newUsuarioComum = new UsuarioComum(data);
        repository.save(newUsuarioComum);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateValueSaldo(@RequestBody @Valid RequestUsuarioComum data){
        Optional<UsuarioComum> optionalUsuarioComum = repository.findById(data.id());
        if (optionalUsuarioComum.isPresent()){
            UsuarioComum usuarioComum = optionalUsuarioComum.get();
            usuarioComum.setSaldo(data.saldo());
            return ResponseEntity.ok(usuarioComum);
        }
        throw new EntityNotFoundException();
    }

}
