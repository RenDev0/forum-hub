package br.com.alura.forum.ForumHub.topicos;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public record DadosListTopicos(
        Long id,
        String titulo,
        String mensagem,
        Date dataCriacao,
        String status,
        String autor,
        String curso
) {
    public DadosListTopicos(Topicos topicos) {
        this(topicos.getId() ,topicos.getTitulo(), topicos.getMensagem(), topicos.getDataCriacao(), topicos.getStatus(), topicos.getAutor(), topicos.getCurso());
    }
}
