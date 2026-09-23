package br.com.dio.desafio.bootcamp;

import br.com.dio.desafio.conteudo.Conteudo;
import br.com.dio.desafio.dev.Dev;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public final class Bootcamp {

    private final String nome;
    private final String descricao;
    private final LocalDate dataInicial;
    private final int duracaoEmDias;
    private final Set<Dev> devsInscritos = new HashSet<>();
    private final Set<Conteudo> conteudos = new LinkedHashSet<>();

    public Bootcamp(String nome, String descricao, LocalDate dataInicial, int duracaoEmDias) {
        this.nome = Objects.requireNonNull(nome, "nome é obrigatório");
        this.descricao = Objects.requireNonNull(descricao, "descrição é obrigatória");
        this.dataInicial = Objects.requireNonNull(dataInicial, "data inicial é obrigatória");
        if (duracaoEmDias <= 0) {
            throw new IllegalArgumentException("duração deve ser positiva");
        }
        this.duracaoEmDias = duracaoEmDias;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataInicial.plusDays(duracaoEmDias);
    }

    public int getDuracaoEmDias() {
        return duracaoEmDias;
    }

    public Set<Conteudo> getConteudos() {
        return Collections.unmodifiableSet(conteudos);
    }

    public Set<Dev> getDevsInscritos() {
        return Collections.unmodifiableSet(devsInscritos);
    }

    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(Objects.requireNonNull(conteudo));
    }

    public void adicionarConteudos(Collection<? extends Conteudo> novos) {
        novos.forEach(this::adicionarConteudo);
    }

    public Set<Conteudo> inscrever(Dev dev) {
        if (acabou()) {
            throw new IllegalStateException("O bootcamp '%s' já encerrou".formatted(nome));
        }
        devsInscritos.add(Objects.requireNonNull(dev));
        return getConteudos();
    }

    public boolean acabou() {
        return getDataFinal().isBefore(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bootcamp other)) return false;
        return nome.equals(other.nome) && dataInicial.equals(other.dataInicial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, dataInicial);
    }

    @Override
    public String toString() {
        return "Bootcamp '%s' (%s a %s, %d conteúdos, %d devs)"
                .formatted(nome, dataInicial, getDataFinal(), conteudos.size(), devsInscritos.size());
    }
}
