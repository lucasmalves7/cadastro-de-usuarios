package com.lucasmalves.caduser.controller;

import com.lucasmalves.caduser.business.UsuarioService;
import com.lucasmalves.caduser.infraestructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Informa que estamos usando o padrão Rest
@RestController
//Todas as requisições vão ser localhost:8080/usuario
@RequestMapping("/usuario")
//Adiciona um metodo construtor
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    //Para gravar dados
    @PostMapping
    //Usa-se o ResponseEntity para ter os retornos dos números http
    public ResponseEntity<Void> salvarUsuario(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        //Qualquer resposta http é bem-vinda.
        return ResponseEntity.ok().build();
    }

    //Busca dados
    @GetMapping
    //RequestParam é porque recebe um parâmetro
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam String email) {
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }

    //Deleta dados
    @DeleteMapping
    public ResponseEntity<Void> deletarUsuarioPorEmail(@RequestParam String email) {
        usuarioService.deletarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }

    //Atualiza dados
    @PutMapping
    public ResponseEntity<Void> atualizarUsuarioPorID(@RequestParam Integer id, @RequestBody Usuario usuario) {
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }

}
