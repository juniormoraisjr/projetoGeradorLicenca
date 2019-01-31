package br.com.sirius.gerador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sirius.gerador.repository.entity.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

	public Usuario findByEmail(String email);
}
