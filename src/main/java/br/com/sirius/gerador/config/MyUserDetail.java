package br.com.sirius.gerador.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.sirius.gerador.repository.entity.Usuario;

public class MyUserDetail extends Usuario implements UserDetails {

	/** serialVersionUID */
	private static final long serialVersionUID = 7857519271706714375L;

	public MyUserDetail() {

	}

	public MyUserDetail(Usuario usuario) {
		super(usuario);
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getPerfis();
	}

	public String getPassword() {
		return getSenha();
	}

	public String getUsername() {
		return getEmail();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}