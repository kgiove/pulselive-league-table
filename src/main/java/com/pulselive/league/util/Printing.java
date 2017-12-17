package com.pulselive.league.util;

import java.util.List;

import com.pulselive.league.beans.LeagueTableEntry;

public class Printing {
	public static void print(List<LeagueTableEntry> leagueTableEntries) {

		System.out.println("\n-----------------------------");
		System.out.println("Premier League Table");
		System.out.println("-----------------------------");
		System.out.format("%15s%15s%15s%15s%15s%15s%15s%15s%20s%15s%n", "Position", "Team", "Played", "Won", "Drawn", "Lost", "Goals For", "Goals Against", "Goal Difference", "Points" );
		
		int[] i = {0};
		leagueTableEntries
				.forEach(leagueTableEntry -> {
						System.out.format("%15d%15s%15d%15d%15d%15d%15d%15d%20d%15d%n", ++i[0], leagueTableEntry.getTeamName(),
						leagueTableEntry.getPlayed(), leagueTableEntry.getWon(), leagueTableEntry.getDrawn(),
						leagueTableEntry.getLost(), leagueTableEntry.getGoalsFor(), leagueTableEntry.getGoalsAgainst(),
						leagueTableEntry.getGoalDifference(), leagueTableEntry.getPoints());});
	}
}
