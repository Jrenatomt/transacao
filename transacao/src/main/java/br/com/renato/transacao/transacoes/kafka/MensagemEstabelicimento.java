package br.com.renato.transacao.transacoes.kafka;

import br.com.renato.transacao.transacoes.Estabelecimento;

public class MensagemEstabelicimento {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public MensagemEstabelicimento() {
    }

    public MensagemEstabelicimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel() {
        return new Estabelecimento(nome,cidade,endereco);
    }
}
