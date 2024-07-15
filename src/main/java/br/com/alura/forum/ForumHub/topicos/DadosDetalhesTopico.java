package br.com.alura.forum.ForumHub.topicos;

import java.util.Date;

public record DadosDetalhesTopico(Long id,
                                  String titulo,
                                  String mensagem,
                                  Date dataCriacao,
                                  String autor,
                                  String status,
                                  String curso) {

    public DadosDetalhesTopico(Topicos topico) {
        this(topico.getId() , topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
