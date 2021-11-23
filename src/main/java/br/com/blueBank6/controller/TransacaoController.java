package br.com.blueBank6.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.blueBank6.models.Transacao;
import br.com.blueBank6.service.TransacaoService;

@RestController
@RequestMapping(path = "/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    @RequestMapping(method = RequestMethod.POST, value = "/salvar")
    public String salvar(@RequestBody Transacao transacao) {
        try {
            service.save(transacao);
            return "Transacão concluída.";
        } catch (Exception e) {
            String msg = e.getMessage();
            return msg;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public List<Transacao>listar(Transacao transacao) {
       return  service.findAll();
       
    }
}
