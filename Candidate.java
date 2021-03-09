package ICP_Final_Project;

public class Candidate extends Voter {
	private int votesReceived;
	private String partyName;
	
	/**
	 * 
	 * @param fullName
	 * @param dateOfBirth
	 * @param nationality
	 * @param gender
	 * @param voterID
	 * @param partyName
	 */
	
	public Candidate(String fullName, String dateOfBirth, String nationality, char gender, int voterID, String partyName) {
		super(fullName,dateOfBirth,nationality, gender,voterID);
		this.partyName = partyName;
		votesReceived = 0;
	}

	
	public void increaseCount() {
		votesReceived++;
	}
	
	public void increaseCountByVote(int votesReceived) {
		votesReceived += votesReceived;
	}
	
	
	@Override
	public String toString() {
		return "Candidate"+ super.toString()+" [votesReceived=" + votesReceived + ", partyName=" + partyName + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((partyName == null) ? 0 : partyName.hashCode());
		result = prime * result + votesReceived;
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
		Candidate other = (Candidate) obj;
		if (partyName == null) {
			if (other.partyName != null)
				return false;
		} else if (!partyName.equals(other.partyName))
			return false;
		if (votesReceived != other.votesReceived)
			return false;
		return true;
	}


	/**
	 * @return the hasVoteReceived
	 */
	public int getVoteReceived() {
		return votesReceived;
	}



	/**
	 * @param hasVoteReceived the hasVoteReceived to set
	 */
	public void setHasVoteReceived(int hasVoteReceived) {
		this.votesReceived = hasVoteReceived;
	}



	/**
	 * @return the partyName
	 */
	public String getPartyName() {
		return partyName;
	}



	/**
	 * @param partyName the partyName to set
	 */
	public void setPartyName(String partyName) {
		this.partyName = partyName;
	}
	
	
}
