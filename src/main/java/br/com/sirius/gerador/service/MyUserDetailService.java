package br.com.sirius.gerador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.sirius.gerador.config.MyUserDetail;
import br.com.sirius.gerador.repository.UsuarioRepository;
import br.com.sirius.gerador.repository.entity.Usuario;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário / Senha inválidos.");
		}

		return new MyUserDetail(usuario);
	}
}