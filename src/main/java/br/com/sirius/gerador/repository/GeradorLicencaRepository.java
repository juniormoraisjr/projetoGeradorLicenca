package br.com.sirius.gerador.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.sirius.gerador.repository.entity.GeradorLicenca;

public interface GeradorLicencaRepository extends MongoRepository<GeradorLicenca, String> {

}
