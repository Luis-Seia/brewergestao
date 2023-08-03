package com.seia.brewergestao.model;

public enum Origem {
    NACIONAL("Nacional"),
    INTERNACIONAL("Onternacional");

    private String descricao;

    Origem(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
