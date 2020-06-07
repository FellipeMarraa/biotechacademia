
package com.biotechacademia.DAO.query;

public class QueryStringCliente {
    private String sql = "SELECT u FROM Usuario as u WHERE 1=1 ";

    public String getSql() {
        return sql;
    }

    public QueryStringCliente(Builder builder) {
        this.sql = builder.sql;
    }

    public static class Builder {
        private String sql = "SELECT u FROM cliente as u WHERE 1=1 ";

        public Builder usuario(String usuario) {
            if (usuario != "" && usuario != null) {
                this.sql += "and u.nome = '" + usuario + "'";
            }

            return this;
        }

        public Builder email(String email) {
            if (email != "" && email != null) {
                this.sql += "and u.email = '" + email + "'";
            }

            return this;
        }


        public QueryStringCliente build() {
            return new QueryStringCliente(this);
        }
    }
}
