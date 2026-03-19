package org.example.service;

import org.example.dto.WebhookRequest;
import org.example.dto.WebhookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class MensagemService {

    private final List<WebhookResponse> mensagens = Collections.synchronizedList(new ArrayList<>());

    public WebhookResponse salvar(WebhookRequest request) {
        WebhookResponse response = new WebhookResponse(request.id(), request.mensagem());
        mensagens.add(response);
        return response;
    }

    public List<WebhookResponse> listarTodas() {
        return List.copyOf(mensagens);
    }
}
