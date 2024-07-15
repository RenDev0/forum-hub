package br.com.alura.forum.ForumHub.topicos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "Topicos")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensagem;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    private String autor;
    private String status;
    private String curso;

    public Topicos(TopicosDto dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = dados.dataCriacao();
        this.autor = dados.autor();
        this.status = dados.status();
        this.curso = dados.curso();
    }

    @PrePersist
    private void onCreate() {
        dataCriacao = new Date();
    }

    public void atualizarTopico(DadosAtualizarTopico dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }

        if (dados.autor() != null) {
            this.autor = dados.autor();
        }

        if (dados.curso() != null) {
            this.curso = dados.curso();
        }
    }
}
