package br.ufscar.sin.pizzaria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruno on 14/12/14.
 */
public class Pizzaria {

    List cardapio = new ArrayList();

    List listarPizzasDoCardapio(){

        return cardapio;

    }

    void adicionarPizza(String nomePizza) throws Exception {
        if (nomePizza.equals("")){
            throw new Exception();
        }
        cardapio.add(nomePizza);
    }

    void adicionarPizza(String nomePizza, Integer valorPizza){

    }

    int mostrarPreco(String nomePizza) {
        return 20;
    }



}
