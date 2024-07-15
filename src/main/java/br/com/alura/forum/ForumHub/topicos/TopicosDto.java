package br.com.alura.forum.ForumHub.topicos;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public record TopicosDto(Long id,
                         @NotBlank String titulo,
                         @NotBlank String mensagem,
                         Date dataCriacao,
                         @NotBlank String autor,
                         String status,
                         @NotBlank String curso) {
}
