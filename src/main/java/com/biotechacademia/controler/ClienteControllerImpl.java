package com.biotechacademia.controler;

import com.biotechacademia.DAO.ClienteDAOImpl;
import com.biotechacademia.DAO.api.ClienteDAO;
import com.biotechacademia.controler.api.ClienteController;
import com.biotechacademia.domain.Cliente;
import com.biotechacademia.utils.EmailValidator;
import com.biotechacademia.vos.ClienteFiltroVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClienteControllerImpl implements ClienteController {

    private ClienteDAO usuarioDAO;

    public ClienteControllerImpl() {
        this.usuarioDAO = ClienteDAOImpl.getInstance();
    }

    @Override
    public void save(Cliente usuario) {
        this.usuarioDAO.save(usuario);
    }

    public void update(Cliente usuario) {
        this.usuarioDAO.update(usuario);
    }

    @Override
    public Cliente efetuaLogin(Cliente usuario) {
        return this.usuarioDAO.efetuaLogin(usuario);
    }

    @Override
    public List<String> validation(Cliente cliente) {
        List<String> erros = new ArrayList<>();
        EmailValidator emailValidator = new EmailValidator();

        if (cliente.getEmail() == null || cliente.getEmail().isEmpty()) {
            erros.add("O email não pode ser vazio");
        }

        if (!emailValidator.validateEmail(cliente.getEmail())) {
            erros.add("Email invalido!");
        }

        if (cliente.getSenha() == null || cliente.getSenha().isEmpty()) {
            erros.add("A senha não pode ser vazia");
        }
//
//        if (usuario.getUsuario() == null || usuario.getUsuario().isEmpty()) {
//            erros.add("O usuário não pode ser vazio");
//        }

        if (cliente.getSenha() != null && cliente.getSenha().length() > 30) {
            erros.add("A senha não pode ter mais que 30 caracteres");
        }

        if (cliente.getSenha() != null && cliente.getSenha().length() < 8) {
            erros.add("A senha não pode ter menos que 8 caracteres");
        }
//
//        if (cliente.getUsuario() != null && cliente.getUsuario().length() > 25) {
//            erros.add("Usuário não pode ter mais que 25 caracteres");
//        }
//
//        if (usuario.getUsuario() != null && usuario.getUsuario().length() < 4) {
//            erros.add("Usuário não pode ter menos que 4 caracteres");
//        }

//        if (usuario.getEmail() != null && usuario.getEmail().length() > 50) {
//            erros.add("O email não pode ter mais que 50 caracteres");
//        }

        ClienteFiltroVo vo = new ClienteFiltroVo();
        vo.setUsuario("");
        vo.setEmail(cliente.getEmail());

        List<Cliente> listaClientes = this.filtrar(vo);

        if (listaClientes.size() > 0) {
            erros.add("Email já cadastrado");
        }

        vo.setEmail("");
        vo.setUsuario(cliente.getEmail());

        listaClientes = this.filtrar(vo);
        if (listaClientes.size() > 0) {
            erros.add("Usuário já cadastrado");
        }

        return erros;
    }

    public List<String> redefSenha(String newPass, String confimPass) {
        List<String> erros = new ArrayList<>();

        if (!Objects.equals(newPass, confimPass)) {
            erros.add("Senhas diferentes");
        }

        if (newPass.length() < 8 || confimPass.length() < 8) {
            erros.add("As senhas necessitam ter no mínimo 8 caracteres");
        }

        return erros;
    }


    @Override
    public List<Cliente> filtrar(ClienteFiltroVo vo) {
        return this.usuarioDAO.pesquisaUsuario(vo);
    }

}
