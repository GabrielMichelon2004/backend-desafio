package com.example.desafiobackend.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioComum,String> {
    List<UsuarioComum> findBySaldo(@Param("saldo") Integer saldo);
}
