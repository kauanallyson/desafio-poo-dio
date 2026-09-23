package br.com.dio.desafio.conteudo;

import java.time.LocalDate;
import java.util.Objects;

public final class Mentoria extends Conteudo {

    private static final double CARGA_HORARIA_FIXA = 2.0d;
    private static final double XP_BONUS = 20.0d;

    private final LocalDate data;

    public Mentoria(String titulo, LocalDate data) {
        super(titulo, CARGA_HORARIA_FIXA);
        this.data = Objects.requireNonNull(data, "data é obrigatória");
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + XP_BONUS;
    }

    @Override
    public String descrever() {
        return "Mentoria '%s' em %s".formatted(getTitulo(), data);
    }
}
