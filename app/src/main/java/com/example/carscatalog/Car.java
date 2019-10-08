package com.example.carscatalog;

import android.media.Image;

public class Car
{
    public String id;
    public String nome;
    public String descricao;
    public String marca;
    public String quantidade;
    public String preco;
    public String imagem;


    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }
}

