package br.com.jcoder.fnbjjapi.enumaradores;

public enum Faixa {

    BRANCA("Branca"),
    CINZA("Cinza"),
    AMARELA("Amarela"),
    LARANJA("Laranja"),
    VERDE("Verde"),
    AZUL("Azul"),
    ROXA("Roxa"),
    MARROM("Marrom"),
    PRETA("Preta"),
    CORAL_PRETA("Coral Preta"),
    CORAL_BRANCA("Coral Branca"),
    VERMELHA("Vermelha");

    private String tipoFaixa;

    Faixa( String valor){
        tipoFaixa = valor;
    }

    public String getTipoFaixa(){
        return tipoFaixa;
    }

}
