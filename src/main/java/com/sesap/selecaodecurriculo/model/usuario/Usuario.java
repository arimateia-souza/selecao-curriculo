package com.sesap.selecaodecurriculo.model.usuario;

import com.sesap.selecaodecurriculo.model.endereco.Endereco;
import com.sesap.selecaodecurriculo.model.escolaridade.Escolaridade;
import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cargoDesejado;
    @Enumerated(value = EnumType.STRING)
    private Escolaridade escolaridade;
    private String observacoes;
    private String curriculo;
    private String ip;
    private LocalDateTime dataEnvio;
    @Embedded
    private Endereco endereco;


    public Usuario(UsuarioDtoRequest u,HttpServletRequest request,String nome, Endereco cepBuscadoIndo) {
        this.nome = u.nome();
        this.email = u.email();
        this.telefone = u.telefone();
        this.cargoDesejado = u.cargoDesejado();
        this.escolaridade = Escolaridade.fromString(u.escolaridade());
        System.out.println("Escolaridade que chegou:" + u.escolaridade());
        this.observacoes = u.observacoes();
        this.curriculo = nome;
        this.ip = request.getRemoteAddr();
        this.dataEnvio = LocalDateTime.now();
        this.endereco = new Endereco(cepBuscadoIndo);
    }


}
