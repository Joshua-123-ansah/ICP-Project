package MIDSEM;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import LAB3.Candidate;
import LAB3.Voter;

public class NationalElectorialOffice {
	
	private Candidate winner;
	public static HashMap<Integer, Voter> voterList = new HashMap<Integer, Voter>();	
	private HashMap<Integer, Candidate> candidateList = new HashMap<Integer, Candidate>();
	
	


	public NationalElectorialOffice() {
		winner = null;
	}
	
	
	
	public Candidate getWinner() {
		if(winner!= null)
		return winner;
		
		return null;
	}
	
	public void setWinner(Candidate winner) {
		this.winner = winner;
	}
	
	public Candidate declareWinner() {
		if(winner != null)
			return winner;
		throw new NullPointerException("There is no winner yet");
	}
	
	public int getTotalVoteCast() {
		return Voter.totalVoteCast;
	}
	
	public void setTotalVoteCast(int newtotalVoteCast) {
	 Voter.totalVoteCast = newtotalVoteCast;
	}
	
	public boolean isWinner(Candidate candidate) {
		if(isAbovefiftyPercent(candidate)) { 
			winner = candidate;
			return true;
		}
		return false;
	}
	
	public boolean isAbovefiftyPercent(Candidate candidate) {
		if(getCandidateVotePercentage(candidate) > 50) {
			return true;
		}
		return false;
	}
	
	
	public int collateCandidateResult(Candidate candidate) {
		return candidate.getVoteAcculated();
	}
	
	public void registerCandidate(Candidate candidate) {
		if(!candidateList.containsValue(candidate)) {
			candidateList.put(candidate.getID(), candidate);
		}
	}
	
	
	public static void addVoter(Voter voter) {
		if(voter != null) {
			voterList.put(voter.getVoterID(), voter);
			return;
		}
		throw new IllegalStateException("The voter is not recognisable");
	}
	
	public void removeVoter(Voter voter) {
		if(voter != null) {
			voterList.remove(voter.getVoterID());
			return;
		}
		throw new IllegalStateException("There is no such voter");
	}
	
	public boolean isPartOfTheRegister(Voter voter) {
		return voterList.containsValue(voter);
	}
	
	public boolean isPartOfTheRegister(int voterID) {
		return voterList.containsKey(voterID);
	}
	
	private float getCandidateVotePercentage(Candidate candidate) {
		return (candidate.getVoteAcculated()/ Voter.totalVoteCast)*100;
	}
	
	
	
	
	public static void main(String[] args) {
		Voter t = new Voter("Eric", 18, 'm',"gh", "accra", 12345);
		Voter t1 = new Voter("Gadzi", 18, 'm',"gh", "aka", 12);
		
		NationalElectorialOffice pk = new NationalElectorialOffice();
		pk.addVoter(t);
		pk.addVoter(t1);
		System.out.println(pk.voterList);
		
		
	}
	
	
	
	
	/**
	 * @return the candidateList
	 */
	public String getCandidateList() {
		StringBuffer list = new StringBuffer();
		for(Map.Entry candidate  : candidateList.entrySet()) {
			list.append(candidate+ "\n");	
		}
		return list.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidateList == null) ? 0 : candidateList.hashCode());
		result = prime * result + ((winner == null) ? 0 : winner.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NationalElectorialOffice other = (NationalElectorialOffice) obj;
		if (candidateList == null) {
			if (other.candidateList != null)
				return false;
		} else if (!candidateList.equals(other.candidateList))
			return false;
		if (winner == null) {
			if (other.winner != null)
				return false;
		} else if (!winner.equals(other.winner))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NationalElectorialOffice [winner=" + winner  
				+ ", TotalVoteCast=" + getTotalVoteCast() + "]"+ "TotalPercentageAttained= "+ getCandidateVotePercentage(winner);
	}

}
