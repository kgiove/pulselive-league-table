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
		setTableEntries(new LeagueTableGenerator(matches).getLeagueTableEntries());
	}
	
	public List<LeagueTableEntry> getTableEntries() {		
		return sort(tableEntries);
	}
	
	public void setTableEntries(List<LeagueTableEntry> leagueTableEntries) {
		this.tableEntries = leagueTableEntries;
	}
}
