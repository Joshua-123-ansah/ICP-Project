import java.util.Objects;
public class Candidate extends Voter {
	private int voterrecieved;
	private String politicalparty;
	private int count;
	
	Candidate(String fullname,String dateofbirth,String nationality,char gender,int voterid,boolean vote,int voterrecieved,String politicalparty){
		super(fullname,dateofbirth,nationality, gender,voterid,vote);
		this.voterrecieved=voterrecieved;
		this.politicalparty=politicalparty;
	}
	
	public void setVoterRecieved(int voterrecieved) {
		this.voterrecieved=voterrecieved;
	}
	
	public void setPoliticalParty(String politicalparty) {
		this.politicalparty=politicalparty;
	}
	public void setCount(int count) {
		this.count = count;
	
	}
	
	public int getVoterRecieved() {
		return voterrecieved;
	}
	public String getPoliticalParty() {
		return politicalparty;
	}
	public int getCount() {
		return count;
	}
	
	// Increase Vote method
	public void increaseCount() {
		count++;
		}
@Override
	public String toString() {
		return "Candidate voterrecieved=" + voterrecieved + "/n"+
				" politicalparty=" + politicalparty;
				
	}
	
	
	@Override
	//Equals method
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Candidate)) {
			return false;
		}
		Candidate other = (Candidate) obj;
		return count == other.count && Objects.equals(politicalparty, other.politicalparty)
				&& voterrecieved == other.voterrecieved;
	}

	
	


@Override 
//Hashcode method
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(count, politicalparty, voterrecieved);
	return result;
}
     
}
