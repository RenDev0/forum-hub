package br.com.alura.forum.ForumHub.controller;

import br.com.alura.forum.ForumHub.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicosController {

    @Autowired
    private TopicosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity abrirTopico(@RequestBody @Valid TopicosDto dados, UriComponentsBuilder uriComponentsBuilder) {
        var topico = new Topicos(dados);
        repository.save(topico);

        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhesTopico(topico));
    }

    @GetMapping
    public ResponseEntity<List<DadosListTopicos>> listarTopicos() {
        var page = repository.findAll().stream()
                .map(DadosListTopicos::new)
                .toList();

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharTopico(@PathVariable Long id) {
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhesTopico(topico)); //teste
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarTopico(@RequestBody @Valid DadosAtualizarTopico dados) {
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarTopico(dados);

        return ResponseEntity.ok(new DadosDetalhesTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirTopico(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}


//{
//        "id" : 1,
//        "titulo" : "msg1",
//        "mensagem" : "teste",
//        "dataCriacao" : "17/09/2001",
//        "autor" : "Maria",
//        "status" : "Resolvido",
//        "curso" : "Java"
//}
