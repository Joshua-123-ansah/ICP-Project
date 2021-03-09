package ICP_Final_Project;

public class Voter {
	private String fullName;
	private String dateOfBirth;
	private String nationality;
	private char gender;
	private int voterID;
	private boolean hasVoted;
	/**
	 * @param fullName
	 * @param dateOfBirth
	 * @param nationality
	 * @param gender
	 * @param voterID
	 */
	public Voter(String fullName, String dateOfBirth, String nationality, char gender, int voterID) {
		super();
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.gender = gender;
		this.voterID = voterID;
		hasVoted = false;
	}
	
	/**
	 * 
	 * @param candidate
	 */
	public void Vote(Candidate candidate, PollingStation pS) {
		 //f(pS.isRegistered(this)) {
		   if(hasVoted)
		    throw new IllegalStateException(" You have voted already!");
		   pS.increaseTotalVoteCast(); 		   
		   candidate.increaseCount();
		   hasVoted=true;
		 //}
		 //else throw new IllegalStateException("You are not registered");
		}
	
	
	@Override
	public String toString() {
		return "Voter [fullName=" + fullName + ", dateOfBirth=" + dateOfBirth + ", nationality=" + nationality
				+ ", gender=" + gender + ", voterID=" + voterID + ", hasVoted=" + hasVoted + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + gender;
		result = prime * result + (hasVoted ? 1231 : 1237);
		result = prime * result + ((nationality == null) ? 0 : nationality.hashCode());
		result = prime * result + voterID;
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
		Voter other = (Voter) obj;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (gender != other.gender)
			return false;
		if (hasVoted != other.hasVoted)
			return false;
		if (nationality == null) {
			if (other.nationality != null)
				return false;
		} else if (!nationality.equals(other.nationality))
			return false;
		if (voterID != other.voterID)
			return false;
		return true;
	}




	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the gender
	 */
	public char getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(char gender) {
		this.gender = gender;
	}
	/**
	 * @return the voterID
	 */
	public int getVoterID() {
		return voterID;
	}
	/**
	 * @param voterID the voterID to set
	 */
	public void setVoterID(int voterID) {
		this.voterID = voterID;
	}
	/**
	 * @return the hasVoted
	 */
	public boolean isHasVoted() {
		return hasVoted;
	}
	/**
	 * @param hasVoted the hasVoted to set
	 */
	public void setHasVoted(boolean hasVoted) {
		this.hasVoted = hasVoted;
	}
	
	
	
	
	
	
	

}
