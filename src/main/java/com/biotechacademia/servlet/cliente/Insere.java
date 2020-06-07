package com.biotechacademia.servlet.cliente;

import com.biotechacademia.controler.ClienteControllerImpl;
import com.biotechacademia.controler.api.ClienteController;
import com.biotechacademia.domain.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/insere-cliente")
public class Insere extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ClienteController usuarioController = new ClienteControllerImpl();
        HttpSession session = request.getSession();


        String email = null;
        String usuario = null;
        String senha = null;
        String foto = request.getParameter("foto");



        if (request.getParameter("email") != null && !request.getParameter("email").isEmpty()) {
            email = (request.getParameter("email"));
        }

        if (request.getParameter("usuario") != null && !request.getParameter("usuario").isEmpty()) {
            usuario = request.getParameter("usuario");

        }

        if (request.getParameter("senha") != null && !request.getParameter("senha").isEmpty()) {
            senha = request.getParameter("senha");

        }

        Cliente novousuario = new Cliente();

//        novousuario.setFoto(foto);
        novousuario.setEmail(email);
//        novousuario.setUsuario(usuario);
        novousuario.setSenha(senha);



        List<String> erros = usuarioController.validation(novousuario);

        if (erros.size() == 0) {
            usuarioController.save(novousuario);

            session.setAttribute("success", "Usuario cadastrado com sucesso");
            response.sendRedirect("/index.jsp");
        } else {
            session.setAttribute("errors", erros);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cadastro.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
