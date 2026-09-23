package br.com.dio.desafio.conteudo;

import java.util.Objects;

public final class Curso extends Conteudo {

    private final String descricao;

    public Curso(String titulo, double cargaHoraria, String descricao) {
        super(titulo, cargaHoraria);
        this.descricao = Objects.requireNonNull(descricao, "descrição é obrigatória");
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * getCargaHoraria();
    }

    @Override
    public String descrever() {
        return "Curso '%s' (%.0fh): %s".formatted(getTitulo(), getCargaHoraria(), descricao);
    }
}
