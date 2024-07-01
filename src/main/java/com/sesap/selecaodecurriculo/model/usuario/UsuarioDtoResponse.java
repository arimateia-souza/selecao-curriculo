package com.sesap.selecaodecurriculo.model.usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record UsuarioDtoResponse(String nome,
                                 String cargoDesejado,
                                 LocalDateTime dataEnvio) {
    public UsuarioDtoResponse(Usuario usuario){
        this(usuario.getNome(),usuario.getCargoDesejado(), usuario.getDataEnvio());
    }

    public String getDataEnvioFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataEnvio.format(formatter);
    }
}
