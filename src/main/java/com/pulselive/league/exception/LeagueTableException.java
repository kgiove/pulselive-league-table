package com.pulselive.league.exception;

/**
 * @author kevin Giove
 */
public class LeagueTableException extends Exception {

	private static final long serialVersionUID = 1L;

	public LeagueTableException(String message, Exception e) {
        super(message, e);
    }

    public LeagueTableException(String message) {
        super(message);
    }
}