package com.sesap.selecaodecurriculo.repository;

import com.sesap.selecaodecurriculo.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
