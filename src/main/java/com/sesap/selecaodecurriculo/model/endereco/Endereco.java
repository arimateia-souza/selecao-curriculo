package com.sesap.selecaodecurriculo.model.endereco;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;



    public Endereco(Endereco cepBuscadoIndo) {
        this.cep = cepBuscadoIndo.getCep();
        this.logradouro = cepBuscadoIndo.getLogradouro();
        this.bairro = cepBuscadoIndo.getBairro();
        this.uf = cepBuscadoIndo.getUf();
    }
}
