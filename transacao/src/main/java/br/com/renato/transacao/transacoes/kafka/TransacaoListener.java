package br.com.renato.transacao.transacoes.kafka;

import br.com.renato.transacao.transacoes.Transacao;
import br.com.renato.transacao.transacoes.TransacaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import javax.transaction.Transactional;

public class TransacaoListener {

    private static final Logger logger = LoggerFactory.getLogger(TransacaoListener.class);

    @Autowired
    private TransacaoRepository repository;

    @Transactional
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void listener(MensagemTransacao response) {
        logger.info("Mensagem recebida!");
        Transacao transacao = response.toModel();
        repository.save(transacao);
        logger.info("Mensagem salva!");
    }
}

