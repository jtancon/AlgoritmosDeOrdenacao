# 📈 Análise de Desempenho de Algoritmos de Ordenação

![Java](https://img.shields.io/badge/language-Java-blue)
![Status](https://img.shields.io/badge/status-Concluído-green)

## 📖 Contexto do Projeto

Este projeto foi desenvolvido como trabalho prático para a disciplina de **Resolução de Problemas Estruturados em Computação**, do 5º período do curso de **Sistemas de Informação** da Pontifícia Universidade Católica do Paraná (PUCPR).

O objetivo principal é aplicar e analisar na prática o comportamento e a eficiência de diferentes algoritmos de ordenação, consolidando os conhecimentos teóricos sobre estruturas de dados e complexidade de algoritmos.

## 🎯 Objetivo

Analisar e comparar o desempenho dos algoritmos **Bubble Sort**, **Insertion Sort** e **Quick Sort** ao serem aplicados em conjuntos de dados com três características distintas:
* **Aleatório**: Dados em ordem aleatória.
* **Crescente**: Dados já previamente ordenados.
* **Decrescente**: Dados em ordem inversa.

A comparação foi realizada medindo o tempo de execução (em milissegundos) de cada algoritmo para ordenar os diferentes conjuntos de dados.

## 💻 Tecnologias Utilizadas
* **Java**: Linguagem de programação principal para a implementação dos algoritmos.

## ✨ Funcionalidades
* **Implementação de 3 algoritmos de ordenação**: Bubble Sort, Insertion Sort e Quick Sort.
* **Leitura de dados a partir de arquivos `.csv`**: O sistema lê os conjuntos de dados de forma flexível.
* **Medição de tempo de execução**: Calcula o tempo que cada algoritmo leva para ordenar os vetores.
* **Exibição de resultados formatados**: Apresenta uma tabela clara no console com os tempos de todos os testes.

## 📁 Estrutura do Projeto
O projeto está organizado da seguinte forma para separar o código-fonte dos dados:
```
/AlgoritmosOrdenacao
|
|-- /src
|   |-- Main.java
|   |-- EstrategiaDeOrdenacao.java
|   |-- BubbleSort.java
|   |-- InsertionSort.java
|   |-- QuickSort.java
|   |-- LeitorCSV.java
|   |-- Swap.java
|   |
|   |-- /conjuntoDeDados
|       |-- aleatorio_100.csv
|       |-- crescente_100.csv
|       |-- ... (todos os outros arquivos .csv)
|
```

## 🚀 Como Executar
1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```
2.  **Abra em uma IDE:**
    * Importe o projeto em sua IDE Java preferida (IntelliJ, Eclipse, VS Code).
3.  **Execute:**
    * Execute o arquivo `Main.java`. A IDE irá compilar e rodar o projeto.
4.  **Verifique a saída:**
    * Os resultados da análise de tempo serão exibidos no console da IDE.

## 📊 Resultados Finais
A tabela abaixo resume os tempos de execução obtidos após os testes:

| Tipo de Conjunto | Tamanho | Bubble Sort (ms) | Insertion Sort (ms) | Quick Sort (ms) |
| :--- | :---: | :---: | :---: | :---: |
| Aleatório | 100 | 1,6475 | 0,3365 | 0,0846 |
| Crescente | 100 | 0,0095 | 0,0053 | 0,3505 |
| Decrescente | 100 | 0,3205 | 0,3492 | 0,0904 |
| Aleatório | 1.000 | 4,6501 | 7,2258 | 0,1682 |
| Crescente | 1.000 | 0,0092 | 0,0143 | 4,4159 |
| Decrescente | 1.000 | 9,1025 | 17,0372 | 0,7629 |
| Aleatório | 10.000 | 165,0913 | 22,7574 | 0,7534 |
| Crescente | 10.000 | 0,0107 | 0,0138 | 97,8186 |
| Decrescente | 10.000 | 125,9052 | 48,9468 | 73,9289 |


### Conclusão da Análise
A prática confirmou a teoria:
* O **Quick Sort** é a escolha ideal para grandes volumes de dados desordenados.
* Para dados já ordenados ou semi-ordenados, algoritmos como o **Insertion Sort** podem ser surpreendentemente mais eficientes devido ao seu baixo custo no melhor caso.

## 👨‍💻 Autores
* **Juan Rodrigues dos Santos Servelo**
* **João Victor Monteiro Tancon**
