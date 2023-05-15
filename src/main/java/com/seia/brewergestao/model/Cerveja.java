package com.seia.brewergestao.model;

import jakarta.validation.constraints.NotBlank;


public class Cerveja {
    @NotBlank
    String sku;

    String nome;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
