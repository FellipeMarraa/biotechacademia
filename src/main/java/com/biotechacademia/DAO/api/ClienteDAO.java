package com.biotechacademia.DAO.api;

import com.biotechacademia.domain.Cliente;
import com.biotechacademia.vos.ClienteFiltroVo;

import java.util.List;

public interface ClienteDAO {
    void save(Cliente usuario);

    Cliente efetuaLogin(Cliente usuario);

    List<Cliente> pesquisaUsuario(ClienteFiltroVo vo);

    void update(Cliente usuario);
}
