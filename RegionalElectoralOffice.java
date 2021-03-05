public class RegionalElectoralOffice {
    private String regionName;
    private int numberOfDistricts;
    private int votesReceived;
    
    RegionalElectoralOffice(String regionName, int numberOfDistricts){
        this.regionName = regionName;
        this.numberOfDistricts = numberOfDistricts;
    }

    //Accessors
    public String getRegionName() {
        return regionName;
    }

    public int getNumberOfDistricts() {
        return numberOfDistricts;
    }

    public int getVotesReceived() {
        return votesReceived;
    }

    //Mutators
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public void setNumberOfDistricts(int numberOfDistricts) {
        this.numberOfDistricts = numberOfDistricts;
    }

    public void setVotesReceived(int votesReceived) {
        this.votesReceived = votesReceived;
    }

    public void collateVotes(int votes) {
        votesReceived += votes;
    } 

    public static void main(String[] args) {
        
    }
}
