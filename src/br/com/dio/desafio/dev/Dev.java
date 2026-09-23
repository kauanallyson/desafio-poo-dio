package br.com.dio.desafio.dev;

import br.com.dio.desafio.bootcamp.Bootcamp;
import br.com.dio.desafio.conteudo.Conteudo;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public final class Dev {

    private final String nome;
    private final Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private final Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public Dev(String nome) {
        this.nome = Objects.requireNonNull(nome, "nome é obrigatório");
    }

    public String getNome() {
        return nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return Collections.unmodifiableSet(conteudosInscritos);
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return Collections.unmodifiableSet(conteudosConcluidos);
    }

    public void inscreverEm(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.inscrever(this));
    }

    public Conteudo progredir() {
        Conteudo proximo = conteudosInscritos.stream()
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "%s não está matriculado em nenhum conteúdo".formatted(nome)));
        conteudosInscritos.remove(proximo);
        conteudosConcluidos.add(proximo);
        return proximo;
    }

    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev dev)) return false;
        return nome.equals(dev.nome);
    }

    @Override
    public int hashCode() {
        return nome.hashCode();
    }

    @Override
    public String toString() {
        return "Dev '%s' (inscritos: %d, concluídos: %d, XP: %.0f)"
                .formatted(nome, conteudosInscritos.size(), conteudosConcluidos.size(), calcularTotalXp());
    }
}
