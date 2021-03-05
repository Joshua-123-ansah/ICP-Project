import java.utils.Hashmap;

public class District {
    String stationName;
    int stationID;
    String region;
    int totalVotesReceived;
    int numberOfPollingStation;
    Hashmap pollVoteCollector = new Hashmap<Integer,Integer>();


    // Default/Null Constructor
    public District(){};

    // Constructor 
    public District(String stationName,int stationID,String region,int totalVotesReceived,int numberOfPollingStation){
    this.stationName = stationName; 
    this.stationID = stationID;
    this.region =region;
    this.totalVotesReceived = totalVotesReceived;
    this.numberOfPollingStation = numberOfPollingStation;
    }
    // Accessor Methods
    public String getStationName() {
        return this.stationName;
    }

    public int getStationID() {
        return this.stationID;
    }
    
    public String getRegion() {
        return this.region;
    }

    public int getTotalVotesReceived() {
        return this.totalVotesReceived;
    }

    public int getNumberOfPollingStation() {
        return this.numberOfPollingStation;
    }

    
    // Mutator Methods
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }


    public void setStationID(int stationID) {
        this.stationID = stationID;
    }


    public void setRegion(String region) {
        this.region = region;
    }


    public void setTotalVotesReceived(int totalVotesReceived) {
        this.totalVotesReceived = totalVotesReceived;
    }

    public void setNumberOfPollingStation(int numberOfPollingStation) {
        this.numberOfPollingStation = numberOfPollingStation;
    }

    // Report Votes Method
    public void reportVotesReceived(Regional region){
        region.getVotesfromDistrict(this.getTotalVotesReceived());
    }

    // Equals Method
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof District)) {
            return false;
        }
        District district = (District) o;
        return Objects.equals(stationName, district.stationName) && stationID == district.stationID && Objects.equals(region, district.region) && totalVotesReceived == district.totalVotesReceived && numberOfPollingStation == district.numberOfPollingStation;
    }

    // toString Method
    @Override
    public String toString() {
        return "{" +
            " stationName='" + getStationName() + "'" +
            ", stationID='" + getStationID() + "'" +
            ", region='" + getRegion() + "'" +
            ", totalVotesReceived='" + getTotalVotesReceived() + "'" +
            ", numberOfPollingStation='" + getNumberOfPollingStation() + "'" +
            "}";

    @Override
    public int hashCode() {
        return Objects.hash(stationName, stationID, region, totalVotesReceived, numberOfPollingStation);
    }

    }

}