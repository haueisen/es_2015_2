package com.tp.es;

import com.badlogic.gdx.Input;

public class NameInputListener implements Input.TextInputListener {

    public String nome = "";
    public boolean cancelado = false;

    @Override
    public void input (String text) {
        nome = text;
        cancelado = false;
    }

    @Override
    public void canceled () {
        nome = "";
        cancelado = true;
    }
}
