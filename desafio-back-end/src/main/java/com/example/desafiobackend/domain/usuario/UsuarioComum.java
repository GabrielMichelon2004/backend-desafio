package com.example.desafiobackend.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuariocomum")
@Entity(name = "usuariocomum")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class UsuarioComum {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String sobrenome;
    private String cpf_cnpj;
    private String email;
    private String senha;
    private Integer saldo;

    public UsuarioComum(String nome,String sobrenome, String cpf_cnpj,String email, String senha, Integer saldo){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf_cnpj = cpf_cnpj;
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
    }

    public UsuarioComum(RequestUsuarioComum data) {
        this.nome = data.nome();
        this.sobrenome = data.sobrenome();
        this.cpf_cnpj = data.cpf_cnpj();
        this.email = data.email();
        this.senha = data.senha();
        this.saldo = data.saldo();
    }


    public void setSaldo(Integer saldo) {
        this.saldo = saldo;
    }
}
