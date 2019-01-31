package br.com.sirius.gerador.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.sirius.gerador.repository.PerfilRepository;
import br.com.sirius.gerador.repository.UsuarioRepository;
import br.com.sirius.gerador.repository.entity.Perfil;
import br.com.sirius.gerador.repository.entity.Usuario;

@Component
public class CargaInicial implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	public void onApplicationEvent(ContextRefreshedEvent e) {
		List<Perfil> perfis = perfilRepository.findAll();

		if (perfis.isEmpty()) {
			perfilRepository.save(new Perfil("ROLE_ADMIN"));

			Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");

			List<Perfil> perfisUsuario = new ArrayList<Perfil>();

			perfisUsuario.add(perfil);

			usuarioRepository.save(new Usuario("junior", "123", "junior", perfisUsuario));
		}
	}
}