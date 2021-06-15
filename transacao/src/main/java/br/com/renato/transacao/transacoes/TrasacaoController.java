package br.com.renato.transacao.transacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/api/transacaoes")
public class TrasacaoController {

    @Autowired
    private TransacaoRepository repository;

    @GetMapping(value = "/cartaoId")
    public ResponseEntity<?> listarComprasRecentes(String cartaoId){

        if (repository.existsByCartaoId(cartaoId)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão informado não existe!");
        }

        List<Transacao> transacoes = repository.findTop10ByCartaoIdOrderByEfetivadaEmDesc(cartaoId);

        return ResponseEntity.ok().body(transacoes);
    }
}
