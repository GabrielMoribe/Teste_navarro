package org.example.controller;

import org.example.dto.WebhookRequest;
import org.example.dto.WebhookResponse;
import org.example.service.MensagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebhookController {

    private final MensagemService mensagemService;
    public WebhookController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping("/webhook")
    public ResponseEntity<WebhookResponse> receberWebhook(@RequestBody WebhookRequest request) {
        WebhookResponse response = mensagemService.salvar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/mensagens")
    public ResponseEntity<List<WebhookResponse>> listarMensagens() {
        return ResponseEntity.ok(mensagemService.listarTodas());
    }
}
