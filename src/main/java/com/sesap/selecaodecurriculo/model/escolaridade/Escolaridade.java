package com.sesap.selecaodecurriculo.model.escolaridade;

public enum Escolaridade {
    FUNDAMENTAL("fundamental"),
    MEDIO("medio"),
    TECNICO("tecnico"),
    SUPERIOR("superior"),
    POS("pos"),
    MESTRADO("mestrado"),
    DOUTORADO("doutorado");
    private String cat;

    Escolaridade(String texto) {
        this.cat = texto;
    }

    public static Escolaridade fromString(String texto) {
        for (Escolaridade escolaridade : Escolaridade.values()) {
            if (escolaridade.cat.equalsIgnoreCase(texto)) {
                return escolaridade;
            }
        }
        throw new IllegalArgumentException("Não foi encontrada categotia com " + texto);
    }
}
