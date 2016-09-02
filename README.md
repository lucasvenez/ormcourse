# Introdução ao Mapeamento Objeto-Relacional

### Autor: Lucas Venezian Povoa

## Sumário

- Introdução
- Mapeamento 1:n
- Mapeamento n:n
- Mapeamento 1:1

## Introdução

O Mapeamento Objeto-Relacional (MOR), em Inglês *Object-Relational Mapping (ORM)*, é uma técnica 
para representar modelos de dados definidos no Modelo Relacional em Modelos Orientado a Objetos.

Essa técnica é necessária para diminuir o tempo de programação utilizado para lidar com as diferenças entre os 
dois modelos e tornar o código mais legível.

Considere o modelo abaixo que descreve os dados de um sistema de Gerenciamento de Vendas com as 
seguintes características:

- Uma pessoa pode realizar diversas vendas;
- Um produto pode ser vendido somente com o preço que está registrado;
- Uma venda pode conter um ou vários produtos;
- Cada produto pertence a uma categoria.

-> ![Modelo de Registro de Vendas](https://raw.githubusercontent.com/lucasvenez/class-orm/master/images/order-model.png) <-

O Modelo Orientado a Objetos correspondente é ilustratado abaixo utilizando o Diagrama de Classes da linguagem <a href="https://en.wikipedia.org/wiki/Unified_Modeling_Language">UML</a>.

<center>
![Modelo de Registro de Vendas](https://raw.githubusercontent.com/lucasvenez/class-orm/master/images/order-uml.png)
</center>

Note que existem algumas diferenças que são muito importantes no que se refere à semântica. Por exemplo, uma pessoa 
realiza nenhuma ou várias compras, sendo que no Modelo Relacional a informação de qual compra pertence a qual pessoa fica contida somente na 
RelVar (tabela) `Order`. No Modelo Orientado a Objetos esse relacionamento pode se tornar bidirecional, i.e., a informação de qual pessoa 
realizou qual venda é descrita tanto na classe `Person` quanto na classe `Order`.

A cardinalidade no Modelo Orientado a Objetos é descrita por meio da estrutura em que o dado é definido. Por exemplo, a característica de 
que uma pessoa pode realizar nenhuma ou infinitas vendas é definida pelo atributo `orders` da classe `Person`. Note que esse atributo não é 
do tipo `Order`, mas sim `List<Order>`. Como uma lista pode conter nenhum ou diversos valores de um determinado tipo, neste caso `Order`, 
o tipo `List<Order>` representa satisfatoriamente a afirmação *"uma pessoa pode realizar **nenhuma ou infinitas** vendas"*.

A relação inversa, i.e., de que uma venda é realizada por uma única pessoa é descrita pelo atributo `person` da classe `Order`. No que o termo 
bidirecional significa que por meio de um objeto do tipo `Order`, que representa uma venda qualquer, é possível acessar a pessoa 
que a realizou, i.e., um objeto do tipo `Person`, e que por meio de um objeto do tipo `Person` é possível acessar todas as compras realizadas, 
i.e., um objeto do tipo `List<Order>`. 
