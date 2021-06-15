package br.com.renato.transacao.transacoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cartao {

    @Id
    private String id;
    @Column(nullable = false)
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
