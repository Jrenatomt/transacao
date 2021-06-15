package br.com.renato.transacao.transacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    List<Transacao> findTop10ByCartaoIdOrderByEfetivadaEmDesc(String cartaoId);

    boolean existsByCartaoId(String cartaoId);
}
