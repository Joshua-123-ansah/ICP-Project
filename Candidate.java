
public class Candidate extends Voter {
	private int voterrecieved;
	private String politicalparty;
	int count=0;
	
	Candidate(String fullname,String dob,String nationality,char gender,int voterid,boolean vote,int voterrecieved,String politicalparty){
		super(fullname,dob,nationality, gender,voterid,vote);
		this.voterrecieved=voterrecieved;
		this.politicalparty=politicalparty;
	}
	
	public void setVoterRecieved(int voterrecieved) {
		this.voterrecieved=voterrecieved;
	}
	
	public void setPoliticalParty(String politicalparty) {
		this.politicalparty=politicalparty;
	}
	
	public int getVoterRecieved() {
		return voterrecieved;
	}
	public String getPoliticalParty() {
		return politicalparty;
	}
	
	public int increaseVoteRecieve() {
		if(this.Vote(vote)==true) {
			int numvote=0;
			numvote+=1;
		
			}
	}
     
}
