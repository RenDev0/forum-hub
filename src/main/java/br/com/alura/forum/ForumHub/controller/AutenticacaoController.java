package br.com.alura.forum.ForumHub.controller;


import br.com.alura.forum.ForumHub.infra.security.DadosTokenJWT;
import br.com.alura.forum.ForumHub.infra.security.TokenService;
import br.com.alura.forum.ForumHub.usuario.DadosAutenticacao;
import br.com.alura.forum.ForumHub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
        var tokenAuth = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authencation = manager.authenticate(tokenAuth);

        var tokenJWT = tokenService.gerarToken((Usuario) authencation.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
