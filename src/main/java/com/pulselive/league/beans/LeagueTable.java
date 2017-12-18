package com.pulselive.league.beans;

import static com.pulselive.league.util.Sorting.sort;

import java.util.List;

import com.pulselive.league.LeagueTableGenerator;


/**
 * @author kgiove
 */
public class LeagueTable {
	
	private List<LeagueTableEntry> tableEntries;

	public LeagueTable(final List <Match> matches) throws Exception {
		LeagueTableGenerator generator = new LeagueTableGenerator(matches);
		generator.populateLeagueTableEntries();
		setTableEntries(generator.getLeagueTableEntries());
	}
	
	public List<LeagueTableEntry> getTableEntries() {		
		return sort(tableEntries);
	}
	
	public void setTableEntries(List<LeagueTableEntry> leagueTableEntries) {
		this.tableEntries = leagueTableEntries;
	}
}
