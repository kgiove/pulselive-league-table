package com.pulselive.league;

import static com.pulselive.league.util.Sorting.sort;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.CoreMatchers.*;

import static com.pulselive.league.util.Summarizing.getClubs;
import static com.pulselive.league.util.Summarizing.filterMatchesByTeam;
import static com.pulselive.league.util.Summarizing.getTotalWon;
import static com.pulselive.league.util.Summarizing.getTotalDrawn;
import static com.pulselive.league.util.Summarizing.getTotalLost;
import static com.pulselive.league.util.Summarizing.getGoalsFor;
import static com.pulselive.league.util.Summarizing.getGoalsAgainst;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

import com.pulselive.league.beans.LeagueTableEntry;
import com.pulselive.league.beans.Match;

/**
 * @author kgiove
 */
public class LeagueTableTest {
	
	@Test
	public void getClubsTest() throws Exception {
		
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Chelsea", "Arsenal", 3, 3), new Match("Chelsea", "Crystal Palace", 1, 0));
		Set<String> expected = Arrays.asList("Bournemouth", "Arsenal", "Crystal Palace", "Chelsea").stream().collect(toSet());
		Set<String> actual = getClubs(matches);		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void filterMatchesByTeamTest() throws Exception{
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Chelsea", "Arsenal", 3, 3), new Match("Chelsea", "Crystal Palace", 1, 0));
		List<Match> expected =  Arrays.asList(new Match("Chelsea", "Arsenal", 3, 3), new Match("Chelsea", "Crystal Palace", 1, 0));
		List<Match> actual = filterMatchesByTeam("Chelsea", matches);
		assertThat(actual, is(expected));
	}
	
	@Test
	public void getTotalWonTest() throws Exception {
		
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Arsenal", "Chelsea", 3, 3), new Match("Arsenal", "Crystal Palace", 1, 0));
		int actual = getTotalWon("Arsenal", matches);
		assertEquals(actual, 1);
	
	}
	
	@Test
	public void getTotalDrawnTest() throws Exception {
		
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Arsenal", "Chelsea", 3, 3), new Match("Arsenal", "Crystal Palace", 1, 0));
		int actual = getTotalDrawn("Arsenal", matches);
		assertEquals(actual, 1);
	}
	
	@Test
	public void getTotalLostTest() throws Exception {
		
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Arsenal", "Chelsea", 3, 3), new Match("Arsenal", "Crystal Palace", 1, 0));
		int actual = getTotalLost("Arsenal", matches);
		assertEquals(actual, 1);
	}
	
	@Test
	public void getGoalsForTest() throws Exception {
		
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Arsenal", "Chelsea", 3, 3), new Match("Arsenal", "Crystal Palace", 1, 0));
		int actual = getGoalsFor("Arsenal", matches);
		assertEquals(actual, 5);
	}
	
	@Test
	public void getGoalsAgainstTest() throws Exception {
		
		List<Match> matches = Arrays.asList(new Match("Arsenal", "Bournemouth", 1, 2),
				new Match("Arsenal", "Chelsea", 3, 3), new Match("Arsenal", "Crystal Palace", 1, 0));
		int actual = getGoalsAgainst("Arsenal", matches);
		assertEquals(actual, 5);
	}
	
	@Test
	public void sortTest() throws Exception {
		
		List<LeagueTableEntry> list = new ArrayList<LeagueTableEntry>();
		
		LeagueTableEntry arsenalEntry = new LeagueTableEntry("Arsenal", 3, 3, 0, 0, 5, 3, 2, 9);
		LeagueTableEntry chelseaEntry = new LeagueTableEntry("Chelsea", 3, 3, 0, 0, 3, 0, 3, 9);
		LeagueTableEntry bournemouthEntry = new LeagueTableEntry("ManchesterCity", 3, 2, 1, 0, 3, 0, 3, 7);
		
		list.add(bournemouthEntry); 
		list.add(chelseaEntry); 
		list.add(arsenalEntry);
		
		// Ensure Correct order
        assertThat(sort(list), contains(arsenalEntry, chelseaEntry, bournemouthEntry));
	}
}
