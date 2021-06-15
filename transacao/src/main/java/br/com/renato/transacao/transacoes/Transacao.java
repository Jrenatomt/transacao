package br.com.renato.transacao.transacoes;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    private String id;

    @Positive
    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelicimento;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;

    @Column(nullable = false, updatable = false)
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(String id, @Positive BigDecimal valor, Estabelecimento estabelicimento, Cartao cartao, LocalDateTime efetivadaEm) {
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

    public Estabelecimento getEstabelicimento() {
        return estabelicimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
