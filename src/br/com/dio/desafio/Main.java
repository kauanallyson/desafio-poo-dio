package br.com.dio.desafio;

import br.com.dio.desafio.bootcamp.Bootcamp;
import br.com.dio.desafio.dev.Dev;
import br.com.dio.desafio.conteudo.Conteudo;
import br.com.dio.desafio.conteudo.Curso;
import br.com.dio.desafio.conteudo.Mentoria;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bootcamp javaAWS = new Bootcamp(
                "Bootcamp Java+AWS em parceria com a CI&T",
                "Melhore seu curriculo e concorra a inúmeros prêmios!",
                LocalDate.now(),
                60);

        javaAWS.adicionarConteudos(List.of(
                new Curso("Curso Java", 120, "Curso da DIO em parceria com a CI&T"),
                new Curso("Curso AWS", 40, "Curso da DIO em parceria com a CI&T"),
                new Mentoria("Mentoria de carreira", LocalDate.now().plusDays(7))));

        Dev kauan = new Dev("Kauan");
        Dev fulano = new Dev("Fulano");
        kauan.inscreverEm(javaAWS);
        fulano.inscreverEm(javaAWS);

        System.out.println(javaAWS);
        System.out.println();

        for (Conteudo conteudo : javaAWS.getConteudos()) {
            System.out.printf("%-60s -> %.0f XP%n", conteudo, conteudo.calcularXp());
        }
        System.out.println();

        kauan.progredir();
        kauan.progredir();
        fulano.progredir();

        System.out.println(kauan);
        System.out.println(fulano);

        try {
            fulano.progredir();
            fulano.progredir();
            fulano.progredir();
        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}
