package com.paralun.app.controller;

import com.paralun.app.dto.PlayerRequest;
import com.paralun.app.dto.PlayerResponse;
import com.paralun.app.dto.WebResponse;
import com.paralun.app.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {

    private PlayerService service;

    @Autowired
    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping(value = "/api/players", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<PlayerResponse> createPlayer(@RequestBody PlayerRequest request) {
        PlayerResponse response = service.cretae(request);
        return  responseData(response);
    }

    @GetMapping(value = "/api/players/{idPlayer}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<PlayerResponse> getPlayer(@PathVariable("idPlayer") String id) {
        PlayerResponse response = service.get(id);
        return  responseData(response);
    }

    @PutMapping(value = "/api/players/{idPlayer}", produces = "application/json", consumes = "application/json")
    public WebResponse<PlayerResponse> updatePlayer(@PathVariable("idPlayer") String id, @RequestBody PlayerRequest request) {
        PlayerResponse response = service.update(id, request);
        return responseData(response);
    }

    @DeleteMapping(value = "/api/players/{idPlayer}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> deletePlayer(@PathVariable("idPlayer") String id) {
        service.delete(id);
        WebResponse<String> web = new WebResponse();
        web.setCode(200);
        web.setMessage("ok");
        web.setData("response");
        return web;
    }

    @GetMapping(value = "api/players", produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<List<PlayerResponse>> getAllPlayer(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "5") int size) {
        List<PlayerResponse> responses = service.getAll(page, size);
        WebResponse<List<PlayerResponse>> web = new WebResponse<>();
        web.setCode(200);
        web.setMessage("ok");
        web.setData(responses);

        return web;
    }

    private WebResponse<PlayerResponse> responseData(PlayerResponse response) {
        WebResponse<PlayerResponse> web = new WebResponse();
        web.setCode(200);
        web.setMessage("ok");
        web.setData(response);

        return web;
    }

}
