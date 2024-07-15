package br.com.alura.forum.ForumHub.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarTopico(@NotNull Long id,
                                   @NotBlank String titulo,
                                   @NotBlank String mensagem,
                                   @NotBlank String autor,
                                   @NotBlank String curso) {
}
