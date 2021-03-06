import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RegionalElectoralOffice {
    private String regionName;
    private int numberOfDistricts;
    private int votesReceived;
    private HashMap listOfDistricts = new HashMap<Integer,District>();
    private HashMap listOfCandidate = new HashMap<Integer, Candidate>();
    
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

    public void collateCandidateVotes(Candidate candidate){ 
       listOfDistricts.forEach((key, value) -> candidate.increaseCount((District)value.collateResults(candidate)));
    
    }

    public static void main(String[] args) {
       HashMap f = new HashMap<String, String>();

        f.put("1", "one");
        f.put("21", "one2");
        f.put("13", "one1");

       f.forEach((key, value) -> System.out.println(key+" : "+value));
    }

    public void getVotesfromDistrict(int totalVotesReceived) {
    }
}
