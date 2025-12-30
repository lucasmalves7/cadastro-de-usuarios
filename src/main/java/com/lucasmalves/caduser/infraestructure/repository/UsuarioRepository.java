package com.lucasmalves.caduser.infraestructure.repository;

import com.lucasmalves.caduser.infraestructure.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//JPARepository é o facilitador. Declarar então o nome da tabela (Usuario) e o tipo de dado que é o ID (Integer)
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Toda vez que eu se acrescenter um Optional será necessário criar
    //uma exceção caso o e-mail não exista.
    //Obs: o findBy é obrigatório na declaração. O que muda é o nome do atributo (exemplo: email)
    Optional<Usuario> findByEmail(String email);

    //Transactional foi importado, pois caso dê algum erro o usuário não pode ser deletado.
    @Transactional
    void deleteByEmail(String email);
}
