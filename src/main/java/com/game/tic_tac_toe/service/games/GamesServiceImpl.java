package com.game.tic_tac_toe.service.games;

import com.game.tic_tac_toe.consts.StatusGames;
import com.game.tic_tac_toe.consts.TypeStones;
import com.game.tic_tac_toe.entity.Games;
import com.game.tic_tac_toe.entity.Moves;
import com.game.tic_tac_toe.repository.GamesRepository;
import com.game.tic_tac_toe.repository.MovesRepository;
import com.game.tic_tac_toe.util.Generate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Service
@Slf4j
public class GamesServiceImpl implements GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private MovesRepository movesRepository;

    @Override
    public Games createGames(Long playerId) {
        Games games = new Games()
                .setGameId(Generate.randomLong())
                .setPlayerOneId(playerId)
                .setPlayerTooId(1L)
                .setStatus(StatusGames.CREATE);
        gamesRepository.save(games);
        return games;
    }

    @Override
    public String moveGames(Long gameId, int pos) {
        Games games = gamesRepository.findByGameId(gameId).get();
        Moves movesPlayerOne = new Moves();
        if (StatusGames.CREATE.equals(games.getStatus())) {
            movesPlayerOne = startPlayerOneMove(gameId, pos);
            gamesRepository.save(games.setStatus(StatusGames.RUN));
        }
        if (StatusGames.RUN.equals(games.getStatus())) {
            movesPlayerOne = updatePlayerMove(gameId, pos);
        }

        Moves movesPlayerToo = playerTooMove(movesPlayerOne);
        movesRepository.saveAll(Arrays.asList(movesPlayerToo, movesPlayerToo));
        return String.format("update moves player one:\n %s \n update moves player too:\n %s", movesPlayerOne, movesPlayerToo);
    }

    private Moves playerTooMove(Moves movesPlayerOne) {
        String field = movesPlayerOne.getField();
        int i;
        for (i = 0; i < 9; i++) {
            if (field.charAt(i) != TypeStones.O.getStones() && field.charAt(i) != TypeStones.X.getStones()) {
                break;
            }
        }
        StringBuilder fieldPlayerToo = new StringBuilder(field);
        fieldPlayerToo.setCharAt(i, TypeStones.O.getStones());

        return createMove(movesPlayerOne.getGameId(), fieldPlayerToo.toString());
    }

    ;

    private Moves startPlayerOneMove(Long gameId, int pos) {
        StringBuilder myName = new StringBuilder("---------");
        myName.setCharAt(pos, TypeStones.X.getStones());

        //gamesRepository.updateStatusByGameId(gameId, StatusGames.RUN.toString());
        return createMove(gameId, myName.toString());
    }

    private Moves updatePlayerMove(Long gameId, int pos) {
        Optional<String> lastFieldByGameId = movesRepository.findLastFieldByGameId(gameId);
        if (lastFieldByGameId.isEmpty()) {
            log.info("not found last move");
            return null;
        }
        StringBuilder field = new StringBuilder(lastFieldByGameId.get());
        field.setCharAt(pos, TypeStones.X.getStones());
        return createMove(gameId, field.toString());
    }

    private Moves createMove(Long gameId, String field) {
        return new Moves()
                .setMoveId(Generate.randomLong())
                .setGameId(gameId)
                .setField(field)
                .setCreateDt(LocalDateTime.now());
    }


}
