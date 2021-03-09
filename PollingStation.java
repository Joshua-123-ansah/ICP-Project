package ICP_Final_Project;

import java.util.HashMap;

public class PollingStation extends Office implements Collatable {
	
	private String districtName;
	 HashMap<Integer,Voter> register=new HashMap<Integer,Voter>();
	
	
	
	public PollingStation(String officeName, int officeID, String region, String districtName) {
		super(officeName, officeID, region);
		this.districtName = districtName;
	
	}

	public int eachCandidateVoteAtThisOfficeLevel(Candidate candidate) { 
	     voteResults.put(candidate, candidate.getVoteReceived());
	     return candidate.getVoteReceived();
	}
	
	
	public HashMap<Candidate, Integer> collatedResults(){
		return voteResults;
	}
	
	
	public void reportCandidateResultToDistrict(DistrictOffice district){
        district.receivedCollatedResults(this);
    }
	
	
	public boolean registerVoter(Voter voter){
        if(register.containsKey(voter.getVoterID()))
            return false;
        register.put(voter.getVoterID(), voter);
        return true;
    }
	
	
	
	 public boolean removeVoter(int voterId){
	        if(register.containsKey(voterId)){
	            register.remove(voterId);
	            return true;
	        }else
	            return false;
	        }
	 
	
	/**
	 * @return the districtName
	 */
	public String getDistrictName() {
		return districtName;
	}

	/**
	 * @param districtName the districtName to set
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((districtName == null) ? 0 : districtName.hashCode());
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
		PollingStation other = (PollingStation) obj;
		if (districtName == null) {
			if (other.districtName != null)
				return false;
		} else if (!districtName.equals(other.districtName))
			return false;
		 else if(this.getOfficeID() != other.getOfficeID())
			 if(!this.getOfficeName().equals(other))
				 return false;
		return true;
	}

	@Override
	public String toString() {
		return "PollingStation [districtName=" + districtName + super.toString()+"]";
	}

	@Override
	public HashMap<Candidate, Integer> collateResults() {
		// TODO Auto-generated method stub
		return voteResults;
	}

	public boolean isRegistered(Voter voter) {
		// TODO Auto-generated method stub
		return register.containsKey(voter);
	}
	
	
	
	

	
}
