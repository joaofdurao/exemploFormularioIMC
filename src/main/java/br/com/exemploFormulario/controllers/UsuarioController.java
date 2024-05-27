package br.com.exemploFormulario.controllers;

import br.com.exemploFormulario.models.Usuario;
import br.com.exemploFormulario.repositories.UsuarioDAO;

public class UsuarioController {

    private UsuarioDAO usuarioDAO;

    public UsuarioController() {
        usuarioDAO = new UsuarioDAO();
    }

    // Criar o registro de um novo usuario
    public boolean saveUsuario(Usuario usuario) {
        try {
            usuarioDAO.createInstance(usuario);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }

    }

    // Encontrar um usuario pelo ID
    public Usuario findUsuarioById(Long usuarioId) {
        try {
            return usuarioDAO.findInstance(usuarioId);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    // Atualizar um usuario
    public boolean updateUsuario(Usuario usuarioAtualizado, Long UsuarioId) {
        try {
            Usuario usuarioAntigo = usuarioDAO.findInstance(UsuarioId);
            usuarioAntigo.setNome(usuarioAtualizado.getNome());
            usuarioAntigo.setPeso(usuarioAtualizado.getPeso());
            usuarioAntigo.setAltura(usuarioAtualizado.getAltura());
            usuarioDAO.updateInstance(usuarioAntigo);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
        
    }

    // Deletar um usuario
    public boolean deleteUsuario(Long UsuarioId) {
        try {
            Usuario usuarioDeletado = usuarioDAO.findInstance(UsuarioId);
            usuarioDAO.deleteInstance(usuarioDeletado);
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
