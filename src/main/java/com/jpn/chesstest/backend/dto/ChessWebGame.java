package com.jpn.chesstest.backend.dto;

import org.springframework.stereotype.Component;

import com.jpn.chesstest.domain.Board;
import com.jpn.chesstest.domain.BoardGame;
import com.jpn.chesstest.domain.Player;
import com.jpn.chesstest.domain.chess.ChessGame;
import com.whitehatgaming.UserInput;

@Component
public class ChessWebGame {
	private BoardGame game;
	private Long gameId;
	private UserInput moves;
	public BoardGame getGame() {
		return game;
	}
	public void setGame(BoardGame game) {
		this.game = game;
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public UserInput getMoves() {
		return moves;
	}
	public void setMoves(UserInput moves) {
		this.moves = moves;
	}
	
	
}
