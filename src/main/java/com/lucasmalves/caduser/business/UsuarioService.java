package com.lucasmalves.caduser.business;

import com.lucasmalves.caduser.infraestructure.entitys.Usuario;
import com.lucasmalves.caduser.infraestructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

//Indica para o Spring que essa é a classe de serviço.
@Service
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //Primeiro metodo será o metodo de salvar usuários
    public void salvarUsuario(Usuario usuario) {
        repository.saveAndFlush(usuario);
    }

    //Segundo metodo será o de buscar usuário
    //Esse metodo tem um retorno:
    //Como eu declarei um "Optional" no "UsuarioRepository", será necessário informar qual será a exceção:
    public Usuario buscarUsuarioPorEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("E-mail não encontrado."));
    }

    //Terceiro metodo deleta usuario por e-mail:
    public void deletarUsuarioPorEmail(String email) {
        repository.deleteByEmail(email);
    }

    //Quarto metodo atualiza usuário por Id:
    public void atualizarUsuarioPorId(Integer Id, Usuario usuario) {
        //Caso o e-mail não exista ele vai retornar a exceção do Segundo Metodo.
        Usuario usuarioEntity = repository.findById(Id).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = usuario.builder()
                //usuario.getNome é diferente de nulo eu preencho meu nome com usuário.getNome, SENÃO (:)
                //será preenchido com o nome da entity.
                .email(usuario.getEmail() != null ?  usuario.getEmail() : usuarioEntity.getEmail())
                .nome(usuario.getNome() != null ? usuario.getNome() : usuarioEntity.getNome())
                .id(usuarioEntity.getId())
                .build();

        repository.saveAndFlush(usuarioAtualizado);
    }
}
