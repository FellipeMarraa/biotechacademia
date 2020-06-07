package com.biotechacademia.controler.api;

import com.biotechacademia.domain.Cliente;
import com.biotechacademia.vos.ClienteFiltroVo;

import java.util.List;

public interface ClienteController {
    void save(Cliente usuario);

    Cliente efetuaLogin(Cliente usuario);

    List<String> validation(Cliente usuario);

    List<Cliente> filtrar(ClienteFiltroVo vo);
}
