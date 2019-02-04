package br.com.sirius.gerador.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.sirius.gerador.config.MongoConfiguration;
import br.com.sirius.gerador.infra.util.cypher.PasswordUtils;
import br.com.sirius.gerador.infra.util.exception.BusinessException;
import br.com.sirius.gerador.repository.entity.GeradorLicenca;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoConfiguration.class)
public class GeradorLicencaServiceTest {

	@Autowired
	private GeradorLicencaService service;
	@Autowired
	private MongoTemplate mongoTemplate;

	private GeradorLicenca entity;

	@Before
	public void setUp() {
		/* Montagem do Cenário */
		entity = new GeradorLicenca();
		entity.setEmpresa("Sirius Software");
		entity.setCnpjEmpresa("30.127.206/0001-48");
		entity.setIdEmpresa("1");
		entity.setIdOrganizacao("1");
		entity.setQtdeDiaLicenca(60);
		entity.setUrlSistema("localhost:8080/sge");
	}

	@After
	public void tearDown() {
		mongoTemplate.dropCollection(GeradorLicenca.class);
	}

	@Test
	public void testGerarTokenLicenca() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDataFinal() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDataInicial() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDataGeracao() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDigitoCnpj() {
		try {
			/* Execução */
			String result = service.createDigitoCnpj(entity.getCnpjEmpresa());

			/* Verificação */
			assertThat(result, is("48"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCreateDigitoCnpj_Vazio() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("");

		try {
			/* Execução */
			service.createCnpjEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA));
		}
	}

	@Test
	public void testCreateDigitoCnpj_Nulo() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa(null);

		try {
			/* Execução */
			service.createCnpjEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA));
		}
	}

	@Test
	public void testCreateOrganizacaoEmpresarial() {
		try {
			/* Execução */
			String result = service.createOrganizacaoEmpresarial(entity);

			/* Verificação */
			assertThat(result, is("Código Organizacao Empresarial Cliente&1"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCreateOrganizacaoEmpresarial_Vazio() {
		/* Montagem do Cenário */
		entity.setIdOrganizacao("");

		try {
			/* Execução */
			service.createOrganizacaoEmpresarial(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL));
		}
	}

	@Test
	public void testCreateOrganizacaoEmpresarial_Nulo() {
		/* Montagem do Cenário */
		entity.setIdOrganizacao(null);

		try {
			/* Execução */
			service.createOrganizacaoEmpresarial(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL));
		}
	}

	@Test
	public void testCreateCnpjEmpresa() {
		try {
			/* Execução */
			String result = service.createCnpjEmpresa(entity);

			/* Verificação */
			assertThat(result, is("Cnpj Empresa&30.127.206/0001-48"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCreateCnpjEmpresa_Vazio() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("");

		try {
			/* Execução */
			service.createCnpjEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA));
		}
	}

	@Test
	public void testCreateCnpjEmpresa_Nulo() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa(null);

		try {
			/* Execução */
			service.createCnpjEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA));
		}
	}

	@Test
	public void createCodigoEmpresa() {
		try {
			/* Execução */
			String result = service.createCodigoEmpresa(entity);

			/* Verificação */
			assertThat(result, is("Código Empresa&1"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void createCodigoEmpresa_Vazio() {
		/* Montagem do Cenário */
		entity.setIdEmpresa("");

		try {
			/* Execução */
			service.createCodigoEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA));
		}
	}

	@Test
	public void createCodigoEmpresa_Nulo() {
		/* Montagem do Cenário */
		entity.setIdEmpresa(null);

		try {
			/* Execução */
			service.createCodigoEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA));
		}
	}

	@Test
	public void createEmpresa() {
		try {
			/* Execução */
			String result = service.createEmpresa(entity);

			/* Verificação */
			assertThat(result, is("Empresa&Sirius Software"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void createEmpresa_Vazia() {
		/* Montagem do Cenário */
		entity.setEmpresa("");

		try {
			/* Execução */
			service.createEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_NOME_EMPRESA));
		}
	}

	@Test
	public void createEmpresa_Nula() {
		/* Montagem do Cenário */
		entity.setEmpresa(null);

		try {
			/* Execução */
			service.createEmpresa(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_NOME_EMPRESA));
		}
	}

	@Test
	public void testCreateContraSenha() throws BusinessException {
		/* Montagem do Cenário */
		String resultTrue = "Contra Senha&" + PasswordUtils.encrip(((1l + 1l + 48) * 10));

		try {
			/* Execução */
			String result = service.createContraSenha(entity);

			/* Verificação */
			assertThat(result, is(resultTrue));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCreateContraSenha_CnpjNulo() throws BusinessException {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa(null);

		try {
			/* Execução */
			service.createContraSenha(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA));
		}
	}

	@Test
	public void testCreateContraSenha_CnpjVazio() throws BusinessException {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("");

		try {
			/* Execução */
			service.createContraSenha(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA));
		}
	}

	@Test
	public void testCreateContraSenha_IdEmpresaNulo() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdEmpresa(null);

		try {
			/* Execução */
			service.createContraSenha(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA));
		}
	}

	@Test
	public void testCreateContraSenha_IdEmpresaVazio() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdEmpresa("");

		try {
			/* Execução */
			service.createContraSenha(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA));
		}
	}

	@Test
	public void testCreateContraSenha_IdOrganizacaoNulo() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdOrganizacao(null);

		try {
			/* Execução */
			service.createContraSenha(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL));
		}
	}

	@Test
	public void testCreateContraSenha_IdOrganizacaoVazio() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdOrganizacao("");

		try {
			/* Execução */
			service.createContraSenha(entity);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL));
		}
	}
}