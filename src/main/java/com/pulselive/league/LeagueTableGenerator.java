package com.pulselive.league;

import static com.pulselive.league.util.Summarizing.filterMatchesByTeam;
import static com.pulselive.league.util.Summarizing.getClubs;
import static com.pulselive.league.util.Summarizing.getGoalsAgainst;
import static com.pulselive.league.util.Summarizing.getGoalsFor;
import static com.pulselive.league.util.Summarizing.getTotalDrawn;
import static com.pulselive.league.util.Summarizing.getTotalLost;
import static com.pulselive.league.util.Summarizing.getTotalWon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.pulselive.league.beans.LeagueTableEntry;
import com.pulselive.league.beans.Match;
import com.pulselive.league.exception.LeagueTableException;

/**
 * @author kgiove
 */
public class LeagueTableGenerator {
	
	private List<Match> matches;
	private List<LeagueTableEntry> leagueTableEntries = new ArrayList<LeagueTableEntry>();
	
	public LeagueTableGenerator(final List<Match> matches) throws Exception{
		if(isNullOrEmpty(matches)){
			throw new LeagueTableException("Matches list cannot be null or empty. Please provide with a correct input.");
		}
		this.matches = matches;
	}	
	
	public void populateLeagueTableEntries(){
		
		Set<String> teams = getClubs(matches);
		teams.forEach(team -> addLeagueTableEntry(createNewLeagueEntry(team, filterMatchesByTeam(team, matches))));
	}
	public LeagueTableEntry createNewLeagueEntry(final String team, final List<Match> matchesByTeam) {

		int played = matchesByTeam.size();
		int won = getTotalWon(team, matchesByTeam);
		int drawn = getTotalDrawn(team, matchesByTeam);
		int lost = getTotalLost(team, matchesByTeam);
		int goalsFor = getGoalsFor(team, matchesByTeam);
		int goalsAgainst = getGoalsAgainst(team, matchesByTeam);
		int goalDifference = goalsFor - goalsAgainst;
		int points = (won * 3) + (drawn * 1);
		return new LeagueTableEntry(team, played, won, drawn, lost, goalsFor, goalsAgainst, goalDifference, points);
	}
	
	public void addLeagueTableEntry(final LeagueTableEntry leagueTableEntry) {
		leagueTableEntries.add(leagueTableEntry);
	}
	
	public List<LeagueTableEntry> getLeagueTableEntries() {
		return leagueTableEntries;
	}
	
	private static boolean isNullOrEmpty(final Collection<?> c) {
		return c == null || c.isEmpty();
	}
}
