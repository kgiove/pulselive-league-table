package com.pulselive.league.util;

import static java.util.Comparator.comparing;

import java.util.List;

import com.pulselive.league.beans.LeagueTableEntry;

public class Sorting {
	
	/**
     * Return a sorted list by points (descending), goal difference, goals for and then team names.
     * @param List<LeagueTableEntry>
     * @return List<LeagueTableEntry>
     */
	
	public static List<LeagueTableEntry> sort(List<LeagueTableEntry> leagueTableEntries){
		leagueTableEntries.sort(comparing(LeagueTableEntry::getPoints).reversed()
				.thenComparing(LeagueTableEntry::getGoalDifference).thenComparing(LeagueTableEntry::getGoalsFor)
				.thenComparing(LeagueTableEntry::getTeamName));
		return leagueTableEntries;
	}
}
