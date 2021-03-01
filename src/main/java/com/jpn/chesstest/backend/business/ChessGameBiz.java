package com.jpn.chesstest.backend.business;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.jpn.chesstest.backend.dto.ChessMoveResponse;
import com.jpn.chesstest.backend.dto.ChessWebGame;
import com.jpn.chesstest.domain.Board;
import com.jpn.chesstest.domain.BoardGame;
import com.jpn.chesstest.domain.Move;
import com.jpn.chesstest.domain.Player;
import com.jpn.chesstest.domain.chess.ChessGame;
import com.jpn.chesstest.domain.chess.pieces.Piece;
import com.jpn.chesstest.exceptions.ChessTestException;
import com.whitehatgaming.UserInput;

@Component
public class ChessGameBiz {
	private java.util.Map<Long, ChessWebGame> games = new java.util.HashMap <Long, ChessWebGame>();
	private long gameIndex=0;
	
	public synchronized Long newGame () {
		gameIndex+=1;
		ChessGame game = new ChessGame();
		game.newGame();
		
		ChessWebGame webGame = new ChessWebGame();
		webGame.setGame(game);
		webGame.setGameId(gameIndex);

		games.put(gameIndex, webGame);
		return gameIndex;
	}
	
	public ChessWebGame getGame (Long gameIndex) {
		return games.get(gameIndex);
	}

	public java.util.List<Player> getPlayers (Long gameIndex) {
		BoardGame game = games.get(gameIndex).getGame();
		
		if (game!=null)
			return game.getPlayers();
		
		return null;
	}

	public Board getBoard (Long gameIndex) {
		BoardGame game = games.get(gameIndex).getGame();
		
		if (game!=null)
			return game.getBoard();
		
		return null;
	}

	public void setMoves (Long gameIndex, UserInput moves) {
		// TODO Check if moves is valid (not null, more than 0, etc)
		ChessWebGame game = games.get(gameIndex);
		game.setMoves(moves);
	}
	
	public ChessMoveResponse doNextMove(Long gameIndex) throws Exception {
		ChessMoveResponse mr = new ChessMoveResponse();
		Piece pieceInCheck = null;
		ChessWebGame game = games.get(gameIndex);
		int[] moves = game.getMoves().nextMove();
		if (moves != null) {
			Move move = new Move(moves);
			if (move != null) {
				pieceInCheck = game.getGame().doMove(move);
			}
		}
		mr.setLastMove(moves==null);
		mr.setPieceInCheck(pieceInCheck);
		return mr;
	}
}
