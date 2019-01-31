package br.com.sirius.gerador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sirius.gerador.repository.entity.Perfil;

public interface PerfilRepository extends MongoRepository<Perfil, String> {

	public Perfil findByNome(String role_admin);
}
