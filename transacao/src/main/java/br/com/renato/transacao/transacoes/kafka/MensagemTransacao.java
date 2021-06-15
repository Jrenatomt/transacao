package br.com.renato.transacao.transacoes.kafka;


import br.com.renato.transacao.transacoes.Cartao;
import br.com.renato.transacao.transacoes.Estabelecimento;
import br.com.renato.transacao.transacoes.Transacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MensagemTransacao {

    private String id;
    private BigDecimal valor;
    private MensagemEstabelicimento estabelicimento;
    private MensagemCartao cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public MensagemTransacao() {
    }

    public MensagemTransacao(String id, BigDecimal valor, MensagemEstabelicimento estabelicimento, MensagemCartao cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelicimento = estabelicimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public MensagemEstabelicimento getEstabelicimento() {
        return estabelicimento;
    }

    public MensagemCartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public Transacao toModel() {
        return new Transacao(id, valor, estabelicimento.toModel(), cartao.toModel(), efetivadaEm);
    }
}
