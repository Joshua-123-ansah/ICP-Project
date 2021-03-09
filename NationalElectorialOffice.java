package ICP_Final_Project;

import java.util.HashMap;

public class NationalElectorialOffice extends Office  implements Collatable{


	private Candidate winner;
	public static HashMap<RegionalOffice, HashMap> voterList = new HashMap<>();	
	private HashMap<Integer, Candidate> candidateList = new HashMap<Integer, Candidate>();
	private HashMap<Integer, RegionalOffice> regionalResults = new HashMap<Integer, RegionalOffice>();
	
	
	
	public NationalElectorialOffice(String officeName, int officeID, String region) {
		super(officeName, officeID, region);
		winner = null;
	}

	public void receiveResultsFromRegion(RegionalOffice regionalOffice) {
		regionalResults.put(regionalOffice.getOfficeID(), regionalOffice)	;
		increaseTotalVoteCastBy(regionalOffice.getTotalVoteCast());
	}


	
	@Override
	public int eachCandidateVoteAtThisOfficeLevel(Candidate candidate) {
		regionalResults.forEach((key, value) ->  candidate.increaseCountByVote(value.eachCandidateVoteAtThisOfficeLevel(candidate)));
		voteResults.put(candidate, candidate.getVoteReceived());
		return candidate.getVoteReceived();
	}

	
	public boolean isWinner(Candidate candidate) {
		if(isAboveFifty(candidate)) {
			winner = candidate;
			return true;
		}
		return false;
	}
	
	public boolean isAboveFifty(Candidate candidate) {
		int percent = candidate.getVoteReceived()/getTotalVoteCast();
		return percent > 0.5;
	}
	
	public Candidate getWinner() {
		return winner;
	}
	
	@Override
	public String toString() {
		return "NationalElectorialOffice [winner=" + winner + ", candidateList=" + candidateList + ", regionalResults="
				+ regionalResults + "]";
	}

	@Override
	public HashMap<Candidate, Integer> collateResults() {	
		return voteResults;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((candidateList == null) ? 0 : candidateList.hashCode());
		result = prime * result + ((regionalResults == null) ? 0 : regionalResults.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		NationalElectorialOffice other = (NationalElectorialOffice) obj;
		if (candidateList == null) {
			if (other.candidateList != null)
				return false;
		} else if (!candidateList.equals(other.candidateList))
			return false;
		if (regionalResults == null) {
			if (other.regionalResults != null)
				return false;
		} else if (!regionalResults.equals(other.regionalResults))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	public void receiveRegisteredVoterList(RegionalOffice regionalOffice,
			HashMap<DistrictOffice, HashMap> regionalRegister) {
		voterList.put(regionalOffice, regionalRegister);
		
	}
	
	public HashMap getRegister() {
		return voterList;
	}
	
	

}
