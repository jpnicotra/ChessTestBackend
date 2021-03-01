package com.jpn.chesstest.backend.ws;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpn.chesstest.backend.business.ChessGameBiz;
import com.jpn.chesstest.backend.dto.ChessMoveResponse;
import com.jpn.chesstest.input.StringUserInput;

@RestController
@RequestMapping("/chess")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class ChessGameResource {
	@Autowired
	protected ChessGameBiz chessGameBiz;

	@PermitAll
	@RequestMapping(path = "/newGame", produces = "application/json")
	public String newGame() {
		Long gameId = chessGameBiz.newGame();
		return "{ \"gameId\": "+gameId+" }";

	}

	@RequestMapping(path = "/playersList/{gameId}", produces = "application/json")
	public Object getGame(@PathVariable Long gameId) {
		return chessGameBiz.getPlayers(gameId);
	}

	@RequestMapping(path = "/board/{gameId}", produces = "application/json")
	public Object getBoard(@PathVariable Long gameId) {
		return chessGameBiz.getBoard(gameId);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/uploadMoves/{gameId}", produces = "application/json")
	public void uploadMoves(@PathVariable Long gameId, @RequestBody String moves) {
		moves = moves.replaceAll("%0A", "\r\n");
		moves = moves.replaceAll("=", "");
		moves = moves.toLowerCase();
		StringUserInput sui = new StringUserInput(moves);
		chessGameBiz.setMoves(gameId, sui);
	}
	
	
	@RequestMapping(path = "/nextMove/{gameId}", produces = "application/json")
	public ChessMoveResponse doNextMove(@PathVariable Long gameId) {
		ChessMoveResponse cr = null;
		try {
			return chessGameBiz.doNextMove(gameId);
		}
		catch (Exception e) {
			cr = new ChessMoveResponse ();
			cr.setError(true);
			cr.setErrorMessage(e.getMessage());
		}
		
		return cr;
	}
	
	
}