package com.church.api.repositories;

import org.springframework.stereotype.Repository;

import com.church.api.domain.BaseRepository;
import com.church.api.entities.Usuario;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario> {

}
