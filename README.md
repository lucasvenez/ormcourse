# Introdução ao Mapeamento Objeto-Relacional

### Autor: Lucas Venezian Povoa

O Mapeamento Objeto-Relacional (MOR), em Inglês *Object-Relational Mapping (ORM)*, é uma técnica 
para representar modelos de dados definido com o Modelo Relacional em um Modelo Orientado a Objetos.

Considere o modelo abaixo que descreve os dados de um sistema de Gerenciamento de Vendas com as 
seguintes características:

- Uma pessoa pode realizar diversas vendas;
- Um produto pode ser vendido somente com o preço que está registrado;
- Um venda pode conter vários um ou vários produtos;
- Cada produto pertence a uma categoria.


![Modelo de Registro de Vendas](https://raw.githubusercontent.com/lucasvenez/class-orm/master/images/order-model.png)
