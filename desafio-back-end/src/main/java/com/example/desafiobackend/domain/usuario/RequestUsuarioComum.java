package com.example.desafiobackend.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public record RequestUsuarioComum(
        String id,
        String nome,
        String sobrenome,
        String cpf_cnpj,
        String email,
        String senha,
        Integer saldo
) {
}
