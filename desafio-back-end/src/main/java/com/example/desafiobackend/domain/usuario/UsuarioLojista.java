package com.example.desafiobackend.domain.usuario;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "usuariolojista")
@Entity(name = "usuariolojista")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioLojista{
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private String sobrenome;
    private String cpf_cnpj;
    private String email;
    private String senha;
    private Double saldo;

}
