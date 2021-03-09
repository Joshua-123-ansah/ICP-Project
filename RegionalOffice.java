package ICP_Final_Project;

import java.util.HashMap;



public class RegionalOffice extends Office implements Collatable {
	
	private int numberOfDistricts;
	private int count;
	private HashMap<Integer,DistrictOffice> listOfDistricts = new HashMap<Integer,DistrictOffice>();
	private HashMap<DistrictOffice,HashMap> regionalRegister=new HashMap<>();
	
	
	RegionalOffice(String regionName, int regionlId, int numberOfDistricts){
        super(regionName, regionlId, regionName);
        this.numberOfDistricts = numberOfDistricts;
    }

	@Override
	public int eachCandidateVoteAtThisOfficeLevel(Candidate candidate) {
		count = 0;
		listOfDistricts.forEach((key, value) -> count += value.eachCandidateVoteAtThisOfficeLevel(candidate)) ;
		candidate.increaseCountByVote(count);
		voteResults.put(candidate, candidate.getVoteReceived());
		return candidate.getVoteReceived();
	}
	
	public void reportToNationalOffice(NationalElectorialOffice hq){
		hq.receiveResultsFromRegion(this);
	}
	
	public int getNumberOfDistricts() {
        return numberOfDistricts;
    }
	
	
	public int getDistrictReported() {
		return listOfDistricts.size();
	}
 

    public void setNumberOfDistricts(int numberOfDistricts) {
        this.numberOfDistricts = numberOfDistricts;
    }


	public void receiveResultsFromDistricts(DistrictOffice districtOffice) {
		if(isReported(districtOffice))
			throw  new IllegalArgumentException("District is reported!!!");
		listOfDistricts.put(districtOffice.getOfficeID(), districtOffice);
		increaseTotalVoteCastBy(districtOffice.getTotalVoteCast());
	}

	private boolean isReported(DistrictOffice districtOffice) {
		
		return listOfDistricts.containsKey(districtOffice.getOfficeID());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + count;
		result = prime * result + ((listOfDistricts == null) ? 0 : listOfDistricts.hashCode());
		result = prime * result + numberOfDistricts;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!super.equals(obj))
			return false;
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegionalOffice other = (RegionalOffice) obj;
		if (count != other.count)
			return false;
		if (listOfDistricts == null) {
			if (other.listOfDistricts != null)
				return false;
		} else if (!listOfDistricts.equals(other.listOfDistricts))
			return false;
		if (numberOfDistricts != other.numberOfDistricts)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegionalOffice [numberOfDistricts=" + numberOfDistricts + ", count=" + count + ", listOfDistricts="
				+ listOfDistricts + "]";
	}

	@Override
	public HashMap<Candidate, Integer> collateResults() {
		// TODO Auto-generated method stub
		return voteResults;
	}

	public void receiveDistrictRegister(DistrictOffice districtOffice,
			HashMap<PollingStation, HashMap> districtRegister) {
		
		regionalRegister.put(districtOffice, districtRegister);
	}
	
	public HashMap getRegister() {
		return regionalRegister;
	}
	
	public void reportRegisterToNational(NationalElectorialOffice hq) {
		hq.receiveRegisteredVoterList(this, regionalRegister);
	}
}
