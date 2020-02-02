package com.vim.fundamentals;

import com.vim.fundamentals.model.FunduUser;
import com.vim.fundamentals.model.GetAllUsersRepsonse;
import com.vim.fundamentals.repository.FunduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
public class FunduController {

    @Autowired
    private FunduRepository repository;

    @Value("${baseUrl}")
    private String baseUrl;

    @GetMapping(value = "/home")
    public FunduResponse getHome() {
        FunduResponse fundu = new FunduResponse();
        fundu.setMessage("Hello");
        return fundu;
    }

    @PostMapping(value = "/user")
    public ResponseEntity addUser(@RequestBody FunduUser user) {
        FunduUser recUser = reconcileUserEmail(user);
        repository.save(recUser);
        return ResponseEntity.accepted().build();
    }

    private FunduUser reconcileUserEmail(FunduUser user) {
        if(user.getEmail() == null) {
            String teamEmail = getTeamEmail();
            user.setEmail(teamEmail);
        }
        return user;
    }

    public static class GetTeamEmailResponse {
        private String teamEmail;

        public String getTeamEmail() {
            return teamEmail;
        }

        public void setTeamEmail(String teamEmail) {
            this.teamEmail = teamEmail;
        }
    }

    private String getTeamEmail() {
        RestTemplate template = new RestTemplate();

        ResponseEntity<GetTeamEmailResponse> response = template.exchange(baseUrl, HttpMethod.GET, null, GetTeamEmailResponse.class);

        return response.getBody().getTeamEmail();
    }

    @GetMapping(value = "/user")
    public ResponseEntity<GetAllUsersRepsonse> getAllUsers() {
        Iterable<FunduUser> users = repository.findAll();
        return ResponseEntity.of(Optional.of(new GetAllUsersRepsonse(users)));
    }
}
