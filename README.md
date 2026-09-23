# Desafio POO: Bootcamp

Projeto Java que modela um bootcamp da DIO para praticar os pilares da Programação Orientada a Objetos.

- **Bootcamp**: nome, descrição, período e lista de conteúdos. Registra os devs inscritos.
- **Conteudo**: base abstrata com título e carga horária. Define o contrato `calcularXp()`.
- **Curso**: conteúdo com descrição. XP proporcional à carga horária.
- **Mentoria**: conteúdo com data e duração fixa. XP base mais bônus.
- **Dev**: nome, conteúdos inscritos e concluídos. Progride um conteúdo por vez e soma o XP.

## Conceitos aplicados

| Pilar          | Onde                                                                                                                                              |
|----------------|---------------------------------------------------------------------------------------------------------------------------------------------------|
| Abstração      | `Conteudo` é `abstract`: só existem instâncias concretas de `Curso` e `Mentoria`.                                                                 |
| Herança        | `Curso` e `Mentoria` estendem `Conteudo`, reaproveitando título e carga horária. A hierarquia é `sealed`, então nenhum outro subtipo pode surgir. |
| Polimorfismo   | `calcularXp()` e `descrever()` são abstratos e cada subtipo implementa sua regra. `Dev.calcularTotalXp()` soma sem saber o tipo concreto.         |
| Encapsulamento | Todos os campos são `private final`. Coleções saem como visões imutáveis. Construtores validam entrada.                                           |

## Como rodar

Requer JDK 21.

```sh
javac -encoding UTF-8 -d out $(find src -name "*.java")
java -cp out br.com.dio.desafio.Main
```

## Créditos

Desafio original criado pela [DIO](https://web.digitalinnovation.one/).
