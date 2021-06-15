package br.com.renato.transacao.transacoes.kafka;

import br.com.renato.transacao.transacoes.Cartao;

public class MensagemCartao {

    private String id;
    private String email;

    @Deprecated
    public MensagemCartao() {
    }

    public MensagemCartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public Cartao toModel() {
        return new Cartao(id,email);
    }
}
