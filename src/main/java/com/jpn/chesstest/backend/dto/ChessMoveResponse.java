package com.jpn.chesstest.backend.dto;

import org.springframework.stereotype.Component;

import com.jpn.chesstest.domain.chess.pieces.Piece;

@Component
public class ChessMoveResponse {
	private boolean lastMove = false;
	private Piece pieceInCheck;
	private boolean error = false;
	private String errorMessage;
	
	public boolean isLastMove() {
		return lastMove;
	}
	public void setLastMove(boolean lastMove) {
		this.lastMove = lastMove;
	}
	public Piece getPieceInCheck() {
		return pieceInCheck;
	}
	public void setPieceInCheck(Piece pieceInCheck) {
		this.pieceInCheck = pieceInCheck;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	
}
