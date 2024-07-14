package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/poll")
public class PollController {

    private final Map<String, CompletableFuture<Void>> listeners = new ConcurrentHashMap<>();

    @GetMapping("/{clientId}")
    public DeferredResult<ResponseEntity<?>> pollUpdates( @PathVariable String clientId) {
        DeferredResult<ResponseEntity<?>> result = new DeferredResult<>(null, ResponseEntity.noContent().build());
        listeners.put(clientId, new CompletableFuture<>());

        result.onCompletion(() -> listeners.remove(clientId));

        listeners.get(clientId).thenAccept(voidValue -> {
            // Triggered when there's an update
            result.setResult(ResponseEntity.ok("Update detected"));
        });

        return result;
    }

    // Endpoint for triggering updates (simulate changes in the backend)
    @PutMapping("/triggerUpdate")
    public ResponseEntity<Void> triggerUpdate() {
        listeners.values().forEach(cf -> cf.complete(null));
        return ResponseEntity.ok().build();
    }
}
