package br.com.dio.desafio.conteudo;

import java.util.Objects;

public abstract sealed class Conteudo permits Curso, Mentoria {

    protected static final double XP_PADRAO = 10.0d;

    private final String titulo;
    private final double cargaHoraria;

    protected Conteudo(String titulo, double cargaHoraria) {
        this.titulo = Objects.requireNonNull(titulo, "título é obrigatório");
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("carga horária deve ser positiva");
        }
        this.cargaHoraria = cargaHoraria;
    }

    public abstract double calcularXp();

    public abstract String descrever();

    public String getTitulo() {
        return titulo;
    }

    public double getCargaHoraria() {
        return cargaHoraria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return Double.compare(cargaHoraria, conteudo.cargaHoraria) == 0
                && titulo.equals(conteudo.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), titulo, cargaHoraria);
    }

    @Override
    public String toString() {
        return descrever();
    }
}
