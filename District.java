import java.util.HashMap;
import java.util.Objects;

public class District {
    String stationName;           //Go back pollingstation
    int stationID;
    String region;
    int totalVotesReceived;
    int numberOfPollingStation;
    private int count=0;
    HashMap<Integer, Integer> pollVoteCollector = new HashMap<Integer, Integer>();
    HashMap<Integer,PollingStation> pollingStationsInfo=new HashMap<Integer,PollingStation>();
    HashMap<String, Integer> candidatesVoteAtDistrictLevel=new HashMap<String,Integer>();


    // Default/Null Constructor
    public District(){};

    // Constructor 
    public District(String stationName,int stationID,String region,int numberOfPollingStation){
    this.stationName = stationName; 
    this.stationID = stationID;
    this.region =region;
    this.numberOfPollingStation = numberOfPollingStation;
    }

    //Receive Polling Station Info
    public void pollingStationInfo(PollingStation pollingstationinfo){
        pollingStationsInfo.put(pollingstationinfo.getStationID(), pollingstationinfo);
    }

    //Get Vote of each condidate and add to get the total vote for each candidate in the district
    
    public void eachCandidateVoteAtDistrictLevel(Candidate candidate){
    //#pollingStationsInfo.forEach((key,value)-> 
       // count=+(((PollingStation) value).candidateTotalVote(candidate.getFullname())));
       int count = 0;
       for (var i : pollingStationsInfo.keySet()) {
            count += ((PollingStation) pollingStationsInfo.get(i)).candidateTotalVote(candidate.getFullname());
            System.out.println(count);
            candidatesVoteAtDistrictLevel.put(candidate.getFullname(), count);
       }

       System.out.println(candidatesVoteAtDistrictLevel.get(candidate.getFullname()));
           
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
    public void reportVotesReceived(RegionalElectoralOffice region){
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
            " stationName=" + getStationName() + " " +
            " stationID='" + getStationID() + " " +
            " region='" + getRegion() + " " +
            " numberOfPollingStation=" + getNumberOfPollingStation() + " " +
            "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(stationName, stationID, region, totalVotesReceived, numberOfPollingStation);

    }

    //Vote From Various Polling Stations
    public int getVoteFromPollingStation(int totalVoteCast){
        return totalVoteCast;
    }



    public static void main(String[] args) {
        District dis=new District("Ayawaso", 122, "GA", 12);
        System.out.println(dis.toString());
        Candidate nana=new Candidate("Nana", "12/01/2002", "Ghana", 'M', 212121, "NPP");

        Voter v1=new Voter("Joshua", "04/01/2002", "Ghanaian", 'M', 12345);
		Voter v2=new Voter("David", "04/01/2002", "Nigerian", 'M',12347);
		Voter v3=new Voter("Gadzi", "04/01/2002", "Ghanaian", 'M', 12343);
		Voter v4=new Voter("Ayeyi", "04/01/2002", "Nigerian", 'M',12349);
		Voter v5=new Voter("Clara", "04/01/2002", "Ghanaian", 'M', 12340);
		Voter v6=new Voter("MyBaby", "04/01/2002", "Nigerian", 'M',12342);
		Voter v7=new Voter("I love You", "04/01/2002", "Ghanaian", 'M',12341);
		Voter v8=new Voter("So Much Jesus", "04/01/2002", "Nigerian", 'M',57392023);
		//System.out.println(v1.toString());
		//System.out.println(v1.equals(v2));
		Candidate mahama=new Candidate("Mahama", "12/01/2002", "Ghana", 'M', 111111, "NDC");

		v1.Vote(nana);
		v2.Vote(mahama);
		v3.Vote(mahama);
		v4.Vote(nana);
		v5.Vote(nana);
		v6.Vote(nana);
		v7.Vote(nana);
		v8.Vote(nana);
		//System.out.println(v1.hasVote());
		System.out.println(nana.getvoteReceived());
		System.out.println(mahama.getvoteReceived());


        dis.eachCandidateVoteAtDistrictLevel(nana);
    }

}