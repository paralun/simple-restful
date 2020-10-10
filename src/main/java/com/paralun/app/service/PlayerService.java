package com.paralun.app.service;

import com.paralun.app.dto.PlayerRequest;
import com.paralun.app.dto.PlayerResponse;

public interface PlayerService {

    PlayerResponse cretae(PlayerRequest request);
    PlayerResponse get(String id);
    PlayerResponse update(String id, PlayerRequest request);
    void delete(String id);
}
