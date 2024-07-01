package com.sesap.selecaodecurriculo.model.usuario;

import com.sesap.selecaodecurriculo.model.endereco.Endereco;
import com.sesap.selecaodecurriculo.model.endereco.EnderecoDtoRequest;
import com.sesap.selecaodecurriculo.model.escolaridade.Escolaridade;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.io.File;

public record UsuarioDtoRequest(@NotBlank String nome,
                                @NotBlank @Email String email,
                                @NotBlank String telefone,
                                @NotBlank String cargoDesejado,
                                @NotBlank String escolaridade,
                                String observacoes,
                                EnderecoDtoRequest endereco) {
}
