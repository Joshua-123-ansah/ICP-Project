package ICP_Final_Project;

import java.util.HashMap;
import java.util.Iterator;

public class DistrictOffice extends Office implements Collatable {
	private int numberOfPollingStation;
	private int count;
	
	private HashMap<Integer, PollingStation> listOfPollingStations;
	private HashMap<PollingStation,HashMap> DistrictRegister=new HashMap<>();
	
	
	public DistrictOffice(String officeName, int officeID, String region, int numberOfPollingStation) {
		super(officeName, officeID, region);
		this.numberOfPollingStation = numberOfPollingStation;
		listOfPollingStations = new HashMap<Integer, PollingStation>();
		numberOfPollingStation = numberOfPollingStation;
	
	}
	
	public void receivedCollatedResults(PollingStation station) {
		if(listOfPollingStations.containsKey(station.getOfficeID())) {
			throw new IllegalStateException("Polling Station has reported!!!");
		}
		listOfPollingStations.put(station.getOfficeID(), station);
		increaseTotalVoteCastBy(station.getTotalVoteCast());
	}


	
	public void reportResults(RegionalOffice region){
		region.receiveResultsFromDistricts(this);
	}
	

	@Override
	public int eachCandidateVoteAtThisOfficeLevel(Candidate candidate) {
		count = 0;
		listOfPollingStations.forEach((key, value) -> count += (value.eachCandidateVoteAtThisOfficeLevel(candidate)));
		candidate.increaseCountByVote(count);
		voteResults.put(candidate, candidate.getVoteReceived());
		return candidate.getVoteReceived();
	}



	public int getVoteFromPollingStation(PollingStation station) {
		return listOfPollingStations.get(station.getOfficeID()).getTotalVoteCast();
	}

	
	public HashMap<Candidate, Integer> collateResults() {
		
		return voteResults;
	}

	/**
	 * @return the numberOfPollingStation
	 */
	public int getNumberOfPollingStation() {
		return numberOfPollingStation;
	}

	/**
	 * @param numberOfPollingStation the numberOfPollingStation to set
	 */
	public void setNumberOfPollingStation(int numberOfPollingStation) {
		this.numberOfPollingStation = numberOfPollingStation;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + count;
		result = prime * result + ((listOfPollingStations == null) ? 0 : listOfPollingStations.hashCode());
		result = prime * result + numberOfPollingStation;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(super.equals(obj))
			return true;
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DistrictOffice other = (DistrictOffice) obj;
		if (count != other.count)
			return false;
		if (listOfPollingStations == null) {
			if (other.listOfPollingStations != null)
				return false;
		} else if (!listOfPollingStations.equals(other.listOfPollingStations))
			return false;
		if (numberOfPollingStation != other.numberOfPollingStation)
			return false;
		return true;
	}

	public void receiveRegister(PollingStation pollingStation, HashMap<Integer, Voter> register) {
		DistrictRegister.put(pollingStation, register);		
	}	
	
	public void reportRegisterToRegional(RegionalOffice region) {
		region.receiveDistrictRegister(this, DistrictRegister);
	}
	
	public HashMap getRegister() {
		return DistrictRegister;
	}
}
