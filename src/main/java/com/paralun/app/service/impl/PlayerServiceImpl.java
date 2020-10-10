package com.paralun.app.service.impl;

import com.paralun.app.dto.PlayerRequest;
import com.paralun.app.dto.PlayerResponse;
import com.paralun.app.exception.NotFoundException;
import com.paralun.app.model.Player;
import com.paralun.app.repository.PlayerRepository;
import com.paralun.app.service.PlayerService;
import com.paralun.app.validation.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository repository;
    private ValidationUtil validation;

    @Autowired
    public PlayerServiceImpl(PlayerRepository repository, ValidationUtil validation) {
        this.repository = repository;
        this.validation = validation;
    }

    @Override
    public PlayerResponse cretae(PlayerRequest request) {
        validation.validate(request);

        Player player = new Player();
        player.setId(request.getId());
        player.setName(request.getName());
        player.setRegion(request.getRegion());
        player.setTeam(request.getTeam());
        player.setAge(request.getAge());
        player.setCreatedAt(new Date());

        repository.save(player);

        return convertPlayerToPlayerResponse(player);
    }

    @Override
    public PlayerResponse get(String id) {
       Player player = repository.findById(id).orElseThrow(NotFoundException::new);

       return convertPlayerToPlayerResponse(player);
    }

    @Override
    public PlayerResponse update(String id, PlayerRequest request) {
        validation.validate(request);

        Player player = repository.findById(id).orElseThrow(NotFoundException::new);

        player.setName(request.getName());
        player.setRegion(request.getRegion());
        player.setTeam(request.getTeam());
        player.setAge(request.getAge());
        player.setUpdatedAt(new Date());

        repository.save(player);

        return convertPlayerToPlayerResponse(player);
    }

    @Override
    public void delete(String id) {
        Player player = repository.findById(id).orElseThrow(NotFoundException::new);
        repository.delete(player);
    }

    private PlayerResponse convertPlayerToPlayerResponse(Player player) {
        PlayerResponse response = new PlayerResponse();
        response.setId(player.getId());
        response.setName(player.getName());
        response.setRegion(player.getRegion());
        response.setTeam(player.getTeam());
        response.setAge(player.getAge());
        response.setCreatedAt(player.getCreatedAt());
        response.setUpdatedAt(player.getUpdatedAt());

        return response;
    }
}
