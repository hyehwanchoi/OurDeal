package com.buy.bankingservice.adapter.in.web.api;

import com.buy.bankingservice.adapter.in.web.dto.BankingRequest;
import com.buy.bankingservice.adapter.in.web.dto.BankingResponse;
import com.buy.bankingservice.application.service.BankingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/banking")
@RequiredArgsConstructor
public class BankingApi {

    private final BankingService bankingService;

    @PostMapping("/transfer")
    public ResponseEntity<BankingResponse> transfer(@RequestBody BankingRequest request) {

        BankingResponse response = bankingService.transfer(request);

        return ResponseEntity.ok(response);
    }
}
