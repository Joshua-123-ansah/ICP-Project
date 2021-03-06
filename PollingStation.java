import java.util.HashMap;

public class PollingStation {

    private String stationName;
    private int stationID;
    private String districtName;
    private int totalRegisteredVoter;
    private int totalVoteCastForPollingStation;
    // The voter class contains nothing. Just created it
    private Voter voterRegister;
    HashMap register=new HashMap<Integer,Voter>();

    //Constructor 
    PollingStation(){} //Defualt Constructor
    PollingStation(String stationName,int stationID,String districtName,int totalRegisteredVoter){ //Overloaded Constructor
        this.stationName=stationName;
        this.stationID=stationID;
        this.districtName=districtName;
        this.totalRegisteredVoter=totalRegisteredVoter;
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

    // Setters
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

    //Auxiliary Methods 
    @Override
    public String toString(){
        return "PollingStationName: "+getStationName()+"\n"+"StationID: "+getStationID()+"\n"+"DistrictName: "+getDistrictName()+"\n"+
        "Total Registered Voters In The District: "+getTotalRegisteredVoter();
    }

    @Override
    public boolean equal(Object anObject){
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

    public void increaseVoteCast(){}


    //I would have to get a Register
    //Get Voter From Register 
    public Voter getVoter(int voterId){
        return (Voter) register.get(voterId);
    }
    //Add Voter to Register 

    public String addVoter(Voter voter){
        register.put(voter.getID(), voter);
        return "Voter Added";
    }
    //Remove Voter From Register 
    public String removeVoter(int voterId){
        register.remove(voterId);
        return "Voter removed";
    }
}