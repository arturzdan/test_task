package com.game.tic_tac_toe.service.players;

import com.game.tic_tac_toe.entity.Players;
import com.game.tic_tac_toe.repository.PlayersRepository;
import com.game.tic_tac_toe.util.Generate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PlayersServiceImpl implements PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    @Override
    public Players add(String name, int pass) {
        Players players = new Players()
                .setPlayerId(Generate.randomLong())
                .setName(name)
                .setPass(pass)
                .setRealPlayer(true);
        return playersRepository.save(players);
    }

    public Players find(String name) throws Exception {
        return playersRepository.findByName(name).orElseThrow(() -> new Exception("Invalid username"));
    }
}
