package com.vim.fundamentals.service;

import com.vim.fundamentals.controller.GetTeamEmailResponse;
import com.vim.fundamentals.model.FunduUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FunduService {

    @Value("${baseUrl}")
    private String baseUrl;

    public FunduUser reconcileUserEmail(FunduUser user) {
        if(user.getEmail() == null) {
            String teamEmail = getTeamEmail();
            user.setEmail(teamEmail);
        }
        return user;
    }

    private String getTeamEmail() {
        RestTemplate template = new RestTemplate();

        ResponseEntity<GetTeamEmailResponse> response = template.exchange(
                baseUrl, HttpMethod.GET,
                null,
                GetTeamEmailResponse.class);

        return response.getBody().getTeamEmail();
    }
}
