package br.com.exemploFormulario.repositories;

import br.com.exemploFormulario.models.Usuario;
import br.com.exemploFormulario.utils.JPAUtils;

public class UsuarioDAO extends InstanceDAO<Usuario> {

    JPAUtils jpaUtils;

	public UsuarioDAO() {
		this.jpaUtils = new JPAUtils();
	}

	@Override
	protected Class<Usuario> getEntityClass() {
		return Usuario.class;
	}
    
}
