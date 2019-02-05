package br.com.sirius.gerador.service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
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
	public void testCriarDigitoCnpj() {
		try {
			/* Execução */
			String result = service.criarDigitoCnpj(entity);

			/* Verificação */
			assertThat(result, is("48"));
		} catch (BusinessException e) {
			fail();
		}
	}

	@Test
	public void testCriarDigitoCnpj_Invalido() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("75.119.313/0001-62");

		try {
			/* Execução */
			String result = service.criarDigitoCnpj(entity);

			/* Verificação */
			assertThat(result, not("48"));
		} catch (BusinessException e) {
			fail();
		}
	}

	@Test
	public void testCriarDigitoCnpj_Vazio() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("");

		try {
			/* Execução */
			service.criarDigitoCnpj(entity);
			fail();
		} catch (BusinessException e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarDigitoCnpj_Nulo() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa(null);

		try {
			/* Execução */
			service.criarDigitoCnpj(entity);
			fail();
		} catch (BusinessException e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarDigitoCnpj_FormatoInvalido() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("30.127.206/0001-");

		try {
			/* Execução */
			service.criarDigitoCnpj(entity);
			fail();
		} catch (BusinessException e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_INVALIDO));
		}
	}

	@Test
	public void testCriarIdOrganizacaoEmpresarial() {
		try {
			/* Execução */
			String result = service.criarIdOrganizacaoEmpresarial(entity, true);

			/* Verificação */
			assertThat(result, is("Código Organizacao Empresarial Cliente&1"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCriarIdOrganizacaoEmpresarial_Vazio() {
		/* Montagem do Cenário */
		entity.setIdOrganizacao("");

		try {
			/* Execução */
			service.criarIdOrganizacaoEmpresarial(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarIdOrganizacaoEmpresarial_Nulo() {
		/* Montagem do Cenário */
		entity.setIdOrganizacao(null);

		try {
			/* Execução */
			service.criarIdOrganizacaoEmpresarial(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarIdEmpresa() {
		try {
			/* Execução */
			String result = service.criarIdEmpresa(entity, true);

			/* Verificação */
			assertThat(result, is("Código Empresa&1"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCriarIdEmpresa_Vazio() {
		/* Montagem do Cenário */
		entity.setIdEmpresa("");

		try {
			/* Execução */
			service.criarIdEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarIdEmpresa_Nulo() {
		/* Montagem do Cenário */
		entity.setIdEmpresa(null);

		try {
			/* Execução */
			service.criarIdEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarEmpresa() {
		try {
			/* Execução */
			String result = service.criarEmpresa(entity, true);

			/* Verificação */
			assertThat(result, is("Empresa&Sirius Software"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCriarEmpresa_Vazia() {
		/* Montagem do Cenário */
		entity.setEmpresa("");

		try {
			/* Execução */
			service.criarEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_NOME_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarEmpresa_Nula() {
		/* Montagem do Cenário */
		entity.setEmpresa(null);

		try {
			/* Execução */
			service.criarEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_NOME_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarCnpjEmpresa() {
		try {
			/* Execução */
			String result = service.criarCnpjEmpresa(entity, true);

			/* Verificação */
			assertThat(result, is("Cnpj Empresa&30.127.206/0001-48"));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCriarCnpjEmpresa_Vazio() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("");

		try {
			/* Execução */
			service.criarCnpjEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarCnpjEmpresa_Nulo() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa(null);

		try {
			/* Execução */
			service.criarCnpjEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarCnpjEmpresa_FormatoInvalido() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("30.127.206/0001-");

		try {
			/* Execução */
			service.criarCnpjEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_INVALIDO));
		}
	}

	@Test
	public void testCriarCnpjEmpresa_NumeroInvalido() {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("12.127.206/0001-11");

		try {
			/* Execução */
			service.criarCnpjEmpresa(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_INVALIDO));
		}
	}

	@Test
	public void testCriarContraSenha() throws BusinessException {
		/* Montagem do Cenário */
		String resultTrue = "Contra Senha&" + PasswordUtils.encrip(((1l + 1l + 48) * 10));

		try {
			/* Execução */
			String result = service.criarContraSenha(entity, true);

			/* Verificação */
			assertThat(result, is(resultTrue));
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void testCriarContraSenha_CnpjFormatoInvalido() throws BusinessException {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("12.127.206/0001-");
		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_INVALIDO));
		}
	}

	@Test
	public void testCriarContraSenha_CnpjNulo() throws BusinessException {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa(null);

		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarContraSenha_CnpjVazio() throws BusinessException {
		/* Montagem do Cenário */
		entity.setCnpjEmpresa("");

		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_CNPJ_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarContraSenha_IdEmpresaNulo() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdEmpresa(null);

		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarContraSenha_IdEmpresaVazio() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdEmpresa("");

		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_EMPRESA_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarContraSenha_IdOrganizacaoNulo() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdOrganizacao(null);

		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL_NULO_VAZIO));
		}
	}

	@Test
	public void testCriarContraSenha_IdOrganizacaoVazio() throws BusinessException {
		/* Montagem do Cenário */
		entity.setIdOrganizacao("");

		try {
			/* Execução */
			service.criarContraSenha(entity, true);
			fail();
		} catch (Exception e) {
			/* Verificação */
			assertThat(e.getMessage(), is(BusinessException.MSG_ID_ORGANIZACAO_EMPRESARIAL_NULO_VAZIO));
		}
	}

	// @Test
	// public void testGerarTokenLicenca() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testCriarDataFinal() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testCriarDataInicial() {
	// fail("Not yet implemented");
	// }
	//
	// @Test
	// public void testCriarDataGeracao() {
	// fail("Not yet implemented");
	// }
}