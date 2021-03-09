package ICP_Final_Project;

public abstract class Office {
	private String officeName;
	private int officeID;
	private String region;
	private int totalVoteCast;
	private int totalVotersRegistered;
	
	



	/**
	 * @param officeName
	 * @param officeID
	 * @param region
	 */
	public Office(String officeName, int officeID, String region) {
		super();
		this.officeName = officeName;
		this.officeID = officeID;
		this.region = region;
	}
	
	
	public void increaseTotalVoteCast() {
		totalVoteCast++;
	}
	
	public void increaseTotalVoteCastBy(int votes) {
		totalVoteCast += votes;
	}
	
	/**
	 * 
	 * @param candidate
	 * @return int: the vote received by the candidate at this office
	 */
   public abstract int eachCandidateVoteAtThisOfficeLevel(Candidate candidate);
	
	
	/**
	 * @return the officeName
	 */
	public String getOfficeName() {
		return officeName;
	}

	/**
	 * @param officeName the officeName to set
	 */
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	/**
	 * @return the officeID
	 */
	public int getOfficeID() {
		return officeID;
	}

	/**
	 * @param officeID the officeID to set
	 */
	public void setOfficeID(int officeID) {
		this.officeID = officeID;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the totalVoteCast
	 */
	public int getTotalVoteCast() {
		return totalVoteCast;
	}

	/**
	 * @param totalVoteCast the totalVoteCast to set
	 */
	public void setTotalVoteCast(int totalVoteCast) {
		this.totalVoteCast = totalVoteCast;
	}

	/**
	 * @return the totalVotersRegistered
	 */
	public int getTotalVotersRegistered() {
		return totalVotersRegistered;
	}

	/**
	 * @param totalVotersRegistered the totalVotersRegistered to set
	 */
	public void setTotalVotersRegistered(int totalVotersRegistered) {
		this.totalVotersRegistered = totalVotersRegistered;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + officeID;
		result = prime * result + ((officeName == null) ? 0 : officeName.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + totalVoteCast;
		result = prime * result + totalVotersRegistered;
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
		Office other = (Office) obj;
		if (officeID != other.officeID)
			return false;
		if (officeName == null) {
			if (other.officeName != null)
				return false;
		} else if (!officeName.equals(other.officeName))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (totalVoteCast != other.totalVoteCast)
			return false;
		if (totalVotersRegistered != other.totalVotersRegistered)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Office [officeName=" + officeName + ", officeID=" + officeID + ", region=" + region + ", totalVoteCast="
				+ totalVoteCast + ", totalVotersRegistered=" + totalVotersRegistered + "]";
	}
}
