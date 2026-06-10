# VerdeScan Motiva - Sprint 2 Java

## Integrantes

* Murilo Justino Arcanjo - RM565470
* Rafael Quattrer - RM562052
* Kaio Corrêa - RM563443
* Rafael Louzã Lopes - RM564963
* Luiz Miguel Martin Crocco - RM562796

---

## Sobre o Projeto

O VerdeScan Motiva é um sistema em Java para monitoramento e priorização de roçada de vegetação em rodovias.

Nesta Sprint 2, o projeto evolui a base criada na Sprint 1, adicionando um motor de regras capaz de analisar trechos de rodovia e indicar automaticamente o tipo de intervenção necessária.

---

## Objetivo da Sprint 2

Criar diferentes comportamentos de crescimento da vegetação e diferentes tipos de intervenção operacional.

O sistema percorre um array de trechos e gera um relatório automático indicando quais KMs precisam de intervenção.

---

## Funcionalidades

* Cadastro de trechos de rodovia.
* Simulação de crescimento da vegetação.
* Diferença de crescimento entre ambiente úmido e seco.
* Monitoramento automático por IoT.
* Geração de relatório de prioridade.
* Indicação automática de intervenção:

    * Roçada mecanizada
    * Roçada manual
    * Pulverização
* Testes conceituais de classe abstrata e interface.

---

## Estrutura do Projeto

```text
src/
├── EquipeManutencao.java
├── IntervencaoOperacional.java
├── Main.java
├── MonitoravelViaIoT.java
├── MotorDeRegras.java
├── Pulverizacao.java
├── RocadaManual.java
├── RocadaMecanizada.java
├── TrechoRodovia.java
└── TrechoRodoviaIoT.java
```

---

## Classes Abstratas

A classe `IntervencaoOperacional` foi criada como classe abstrata para representar uma intervenção genérica.

Ela possui o método abstrato:

```java
public abstract void executarServico(TrechoRodovia trecho);
```

As classes filhas implementam esse método de acordo com o serviço realizado:

* `RocadaMecanizada`
* `RocadaManual`
* `Pulverizacao`

### Pergunta de reflexão

Não faz sentido para a Motiva executar apenas uma "Intervenção Operacional" genérica, porque a equipe precisa saber qual serviço será feito, quais equipamentos serão usados e qual prioridade operacional será aplicada.

Por isso, a classe abstrata serve como modelo base, enquanto as classes filhas definem o comportamento real de cada intervenção.

---

## Interfaces

A interface `MonitoravelViaIoT` representa um contrato para trechos que conseguem transmitir dados por sensores.

```java
public interface MonitoravelViaIoT {
    double transmitirDadosSensor();
}
```

A classe `TrechoRodoviaIoT` implementa essa interface, permitindo que trechos com sensores atualizem automaticamente o nível da vegetação.

### Diferença entre classe abstrata e interface

Uma classe abstrata representa uma base comum dentro de uma hierarquia, podendo possuir atributos, construtor e métodos concretos.

Uma interface representa um contrato de comportamento, permitindo que uma classe tenha uma capacidade adicional sem depender diretamente de uma hierarquia.

No projeto:

* `IntervencaoOperacional` é uma classe abstrata.
* `MonitoravelViaIoT` é uma interface.

---

## Motor de Regras

A classe `MotorDeRegras` percorre um array de `TrechoRodovia` e define a prioridade conforme o nível da vegetação:

* A partir de 80 cm: prioridade alta e roçada mecanizada.
* De 50 cm até 79 cm: prioridade média e roçada manual.
* Abaixo de 50 cm: prioridade baixa e pulverização preventiva.

Trechos com IoT transmitem dados automaticamente.

Trechos sem IoT recebem crescimento estimado conforme o tipo de ambiente.

---

## Testes Conceituais

A classe `Main` executa testes conceituais demonstrando:

1. Que a classe abstrata `IntervencaoOperacional` não pode ser instanciada diretamente.
2. Que um mock chamado `MockSensorIoT` pode implementar a interface `MonitoravelViaIoT`.

---

## Como Executar

Abra o projeto em uma IDE Java, como IntelliJ IDEA.

Execute o arquivo:

```text
Main.java
```

Ou, pelo terminal, dentro da pasta do projeto:

```bash
javac src/*.java
java -cp src Main
```

---

## Resultado Esperado

O console deve exibir:

* Relatório de prioridade dos trechos.
* Crescimento estimado da vegetação.
* Dados transmitidos por sensores IoT.
* Intervenção indicada para cada trecho.
* Execução dos testes conceituais.
