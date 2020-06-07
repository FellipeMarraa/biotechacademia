package com.biotechacademia.DAO;

import com.biotechacademia.DAO.api.ClienteDAO;
import com.biotechacademia.DAO.query.QueryStringCliente;
import com.biotechacademia.domain.Cliente;
import com.biotechacademia.utils.HibernateUtil;
import com.biotechacademia.vos.ClienteFiltroVo;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private Session session;
    private static ClienteDAO USUARIO_DAO;

    private ClienteDAOImpl() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public static ClienteDAO getInstance() {
        if (USUARIO_DAO == null) {
            USUARIO_DAO = new ClienteDAOImpl();
        }

        return USUARIO_DAO;
    }

    @Override
    public void save(Cliente cliente) {
        try {
            session.beginTransaction();
            session.save(cliente);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public Cliente efetuaLogin(Cliente cliente) {
        try {
            session.beginTransaction();

            Query q = session.createQuery("select u from Cliente as u where u.email= :email and u.senha = :senha");
            q.setParameter("email", cliente.getEmail());
            q.setParameter("senha", cliente.getSenha());
            List<Cliente> usuarios = q.list();


            Cliente aux;
            if (usuarios.get(0) != null) {
                aux = new Cliente();

                aux.setId(usuarios.get(0).getId());
//                aux.setUsuario(usuarios.get(0).getUsuario());
//                aux.setFoto(usuarios.get(0).getFoto());
                aux.setSenha(usuarios.get(0).getSenha());
                session.getTransaction().commit();

                return aux;
            }

            session.getTransaction().commit();
            return null;
        } catch (Exception e) {
            session.getTransaction().rollback();

        }
        return null;
    }


    @Override
    public List<Cliente> pesquisaUsuario(ClienteFiltroVo vo) {
        try {
            QueryStringCliente queryString = new QueryStringCliente.Builder()
//                    .usuario(vo.getUsuario())
//                    .email(vo.getEmail())
                    .build();

            session.getTransaction().begin();
            List<Cliente> usuarios = session.createQuery(queryString.getSql()).list();
            session.getTransaction().commit();

            return usuarios;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public void update(Cliente usuario) {
        try {
            session.beginTransaction();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }


}
