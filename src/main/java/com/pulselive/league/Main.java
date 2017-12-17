package com.pulselive.league;

import static com.pulselive.league.util.Printing.print;
import java.util.Arrays;
import java.util.List;

import com.pulselive.league.beans.LeagueTable;
import com.pulselive.league.beans.LeagueTableEntry;
import com.pulselive.league.beans.Match;


public class Main {
	public static final List<Match> matches =
            Arrays.asList( new Match("Stoke City", "Chelsea", 2, 1),
            			   new Match("Bournemouth", "Stoke City", 2, 1),            			   
            			   new Match("Liverpool", "Chelsea", 2, 1),
            			   new Match("Liverpool", "Stoke City", 2, 1),
            			   new Match("Spurs", "Man City", 2, 1),
            			   new Match("Spurs", "Chelsea", 2, 1),
            			   new Match("Man Utd", "Arsenal", 2, 1),
            			   new Match("Man Utd", "Spurs", 2, 1),
            			   new Match("Man Utd", "Stoke City", 2, 1));

	public static void main(String[] args) throws Exception{
		
		LeagueTable table = new LeagueTable(matches);
		List<LeagueTableEntry> list = table.getTableEntries();		
		print(list);
	}
}
