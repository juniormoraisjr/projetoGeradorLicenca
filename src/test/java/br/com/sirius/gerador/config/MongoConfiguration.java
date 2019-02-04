package br.com.sirius.gerador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@ComponentScan("br.com.sirius.gerador")
@EnableMongoRepositories(basePackages = "br.com.sirius.gerador.repository")
public class MongoConfiguration extends AbstractMongoConfiguration {

	private static final String DB_NAME = "projetoestudojunittest";

	private static final String DB_HOST = "localhost";

	private static final String DB_PORT = "27017";

	private static final String DB_EXECUTION = "Fongo";

	@Override
	protected String getDatabaseName() {
		return DB_NAME;
	}

	@Override
	@Bean
	public Mongo mongo() {
		if (DB_EXECUTION.equals("Fongo")) {
			// Utiliza o Fongo (Implementação java in-memory do MongoDB)
			return new Fongo(getDatabaseName()).getMongo();
		} else {
			// Utilizar MongoDB Local
			return new MongoClient(DB_HOST + ":" + DB_PORT);
		}
	}

	@Override
	protected String getMappingBasePackage() {
		return "br.com.sirius.gerador.repository";
	}
}