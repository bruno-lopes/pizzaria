package br.ufscar.sin.pizzaria

import spock.lang.Specification
import spock.lang.Unroll

class PizzariaTest extends Specification {
    
    def "Listar pizzas do cardápio de uma pizzaria nova" () {

        given: "Tem uma nova pizzaria"
        def pizzaria = new Pizzaria()

        when:"Lista as pizzas disponíveis no cardápio"
        def listaPizzas = pizzaria.listarPizzasDoCardapio()

        then: "Não vai ter nenhuma pizza"
        listaPizzas == []

    }

    @Unroll
    def "Ao adicionar a pizza #nomePizza no cardápio, o cardapio apresenta essalista de pizzas: #listaEsperadaDePizzas" (){
        given: "Tem uma nova pizzaria"
        def pizzaria = new Pizzaria()

        when: "Adcionar uma nova pizza"
        pizzaria.adicionarPizza(nomePizza)

        and: "Listar as pizzas do cardápio"
        def listaPizzas = pizzaria.listarPizzasDoCardapio()

        then: "Só essa pizza aparece na lista"
        listaPizzas == listaEsperadaDePizzas

        where:
        nomePizza          || listaEsperadaDePizzas
        "Portuguesa"       || ["Portuguesa"]
        "Bahiana"          || ["Bahiana"]
    }

    def "Ao adicionar pizza sem nome, dá excessão" (){
        given: "Tem uma nova pizzaria"
        def pizzaria = new Pizzaria()

        when: "Adcionar uma pizza sem nome"
        pizzaria.adicionarPizza("")

        then:"Dá excessão"
        thrown Exception
    }

    def "Mostrar valor de uma pizza Portuguesa"() {

        given: "Dada uma nova pizzaria"
        def pizzaria = new Pizzaria()
        pizzaria.adicionarPizza("Portuguesa", 20)

        when: "Mandar exibir o preço de uma pizza"
        def preco = pizzaria.mostrarPreco("Portuguesa")

        then:"Preço deve ser igual o preço informado"
        preco == 20

    }

    def "Mostrar valor de uma pizza Bahiana"() {

        given: "Dada uma nova pizzaria"
        def pizzaria = new Pizzaria()
        pizzaria.adicionarPizza("Bahiana", 25)

        when: "Mandar exibir o preço de uma pizza"
        def preco = pizzaria.mostrarPreco("Portuguesa")

        then:"Preço deve ser igual o preço informado"
        preco == 25

    }

}
