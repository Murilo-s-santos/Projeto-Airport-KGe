# Projeto API Airports
## Descrição
O API Airports é uma API desenvolvida como exercício prático em sala de aula, com o objetivo de fixar os conteúdos aprendidos sobre Java e Spring Boot. O projeto foi construído utilizando ferramentas como NetBeans para o desenvolvimento e Postman para testes e consumo da API. O foco principal da atividade foi o desenvolvimento do back-end, razão pela qual não foi implementada uma interface gráfica (front-end). O Postman foi utilizado para simular as requisições e visualizar as respostas da API, atendendo plenamente aos objetivos propostos em aula.
## Funcionamento
A API funciona a partir da seguinte lógica:
1. O usuário informa a localização de um determinado ponto geográfico.
2. A API processa essa informação e realiza cálculos baseados em coordenadas geográficas (eixos X e Y) considerando a superfície do planeta Terra.
3. Por meio desse cálculo (triangulação), a API identifica quais aeroportos estão próximos à localização informada.
4. Como resposta, são retornados todos os aeroportos encontrados dentro da área de proximidade definida.
5. O objetivo principal da aplicação é fornecer, de forma simples e eficiente, uma listagem de aeroportos próximos a um local informado pelo usuário, demonstrando a aplicação prática de conceitos de back-end, APIs REST e manipulação de dados geográficos.


