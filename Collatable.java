package ICP_Final_Project;

import java.util.HashMap;

public interface Collatable {
	
	HashMap<Candidate, Integer> voteResults = new HashMap<Candidate, Integer>();

	public abstract HashMap<Candidate, Integer> collateResults();
	
}
