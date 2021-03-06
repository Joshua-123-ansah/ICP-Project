import java.util.HashMap;

public class PollingStation {

    private String stationName;
    private int stationID;
    private String districtName;
    private int totalRegisteredVoter;
    private int totalVoteCastForPollingStation;
    private int count;
    // The voter class contains nothing. Just created it
    private Voter voterRegister;
    static HashMap register=new HashMap<Integer,Voter>();
    static HashMap eachCandidateResult=new HashMap<String,Integer>();

    //private HashMap candidateList = new HashMap<Integer, Candidate>();
    
    //Constructor 
    PollingStation(){} //Defualt Constructor
    PollingStation(String stationName,int stationID,String districtName,int totalRegisteredVoter){ //Overloaded Constructor
        this.stationName=stationName;
        this.stationID=stationID;
        this.districtName=districtName;
        this.totalRegisteredVoter=totalRegisteredVoter;
    }

    //Methods that stores in the HashMap candidates name and total vote
    public int candidateTotalVote(String candidatesName){
        if(!eachCandidateResult.containsKey(candidatesName))
            System.out.println("Candidates Name Is Not Found");
        return (int) eachCandidateResult.get(candidatesName);
    }

    //Take total vote of each candidate and put it inside the hashmap //change into
    public void into(Candidate candidate){
        eachCandidateResult.put(candidate.getFullname(), candidate.getvoteReceived());
    }

    //Report to district
    public void reportCandidateResultToDistrict(District district){
        district.
    }
     

 

    // Getters
    public String getStationName() {
        return stationName;
    }

    public int getStationID() {
        return stationID;
    }

    public String getDistrictName() {
        return districtName;
    }

    public int getTotalRegisteredVoter() {
           return totalRegisteredVoter;
    }

    public Voter getVoterRegister() {
        return voterRegister;
    }

    // S etters
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public void setTotalRegisteredVoter(int totalRegisteredVoter) {
        this.totalRegisteredVoter = totalRegisteredVoter;
    }

    public void setVoterRegister(Voter voterRegister) {
        this.voterRegister = voterRegister;
    }

    // public int getCandidateVote(Candidate candidate){
    //     return candidateList.get(candidate.getVoterId()).getTotalVotesReceived();
    // }

    //Auxiliary Methods 
    @Override
    public String toString(){
        return "PollingStationName: "+getStationName()+"\n"+"StationID: "+getStationID()+"\n"+"DistrictName: "+getDistrictName()+"\n"+
        "Total Registered Voters In The District: "+getTotalRegisteredVoter();
    }

    @Override
    public boolean equals(Object anObject){
        if(this==anObject){
            return true;
        }
        if(anObject instanceof PollingStation){
            PollingStation station=(PollingStation) anObject;
            if(this.stationName.equals(station.stationName)){
                if(this.stationID==station.stationID){
                    if(this.districtName.equals(station.districtName)){
                        if(this.totalRegisteredVoter==station.totalRegisteredVoter){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.stationID;
    }

    public void increaseVote(int votersID){
        if(register.containsKey(votersID)){
            if(((Voter) register.get(votersID)).hasVote())
                count++;
        }else{
            System.out.println("Your ID is not in the register");
        }
        
    }

    public int totalVoteCast(){
        return count;
    }

    //I would have to get a Register
    //Get Voter From Register 
    public Voter getVoter(int voterId){
        if(!register.containsKey(voterId))
            System.out.println("Incorrect Voter ID");
        return (Voter) register.get(voterId); 
    }
    //Add Voter to Register 

    public boolean addVoter(Voter voter){
        if(register.containsKey(voter.getVoterId()))
            return false;
        register.put(voter.getVoterId(), voter);
        return true;
    }
    //Remove Voter From Register 
    public boolean removeVoter(int voterId){
        if(register.containsKey(voterId)){
            register.remove(voterId);
            return true;
        }else{
            return false;
        }
        
    }

    //Report to district 
    public void reportVoteCast(District district){
        district.getVoteFromPollingStation(this.totalVoteCast());
    }

    public static void main(String[] args) {
        PollingStation pp1=new PollingStation("Ayawaso", 1223, "Ayawaso Dis", 300);
        PollingStation pp2=new PollingStation("Dodowu", 3423, "Ay Dis", 300);
        //System.out.println(pp1.toString());
        //System.out.println(pp1.equals(pp2));
        //System.out.println(pp1.hashCode());

        Voter v1=new Voter("Joshua", "04/01/2002", "Ghanaian", 'M', 71392023);
		Voter v2=new Voter("David", "04/01/2002", "Nigerian", 'M',57392023);
        Voter v3=new Voter("Gadzi", "04/01/2002", "Nigerian", 'M',57392053);
        
        Candidate nana=new Candidate("Nana", "12/01/2002", "Ghana", 'M', 212121, "NPP");

        register.put(v1.getVoterId(),v1);
        register.put(v2.getVoterId(),v2);

        v1.Vote(nana);
        pp1.increaseVote(71392023);
        
        // System.out.println(pp1.getVoter(71392023));
        System.out.println(pp1.removeVoter(71392023));
    }
}