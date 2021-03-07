import java.util.Objects;

/*
*
* Class: Voter
* Access Modifier: Public
* Inheritance  Voter Class
* 
*/
public class Candidate extends Voter {
	
	/*
	 * Instance Variables
	 * @voteReceived
	 * @politicalparty
	 * @count
	*/
	private int voteRecieved;
	private String politicalparty;
	
	/*
	 *  Constructor
	 * @param fullname
	 * @param dateofbirth
	 * @param nationality
	 * @param gender
	 * @param voterid
	 * @param voteReceived
	 * @param politicalparty
	 * 
	 */
	Candidate(String fullname,String dateofbirth,String nationality,char gender,int voterid,String politicalparty){
		super(fullname,dateofbirth,nationality, gender,voterid);
		this.politicalparty=politicalparty;
	}
	
	/*
	 * Mutator methods : 
	 * setvoteReceived  @param voteReceived
	 * setPoliticalParty       @param politicalparty
	 * setCount   @param count
	 */
	public void setvoteReceived(int voteReceived) {
		this.voteRecieved=voteReceived;
	}
	
	public void setPoliticalParty(String politicalparty) {
		this.politicalparty=politicalparty;
	}
	
	/*
	 * Accessor Method 
	 * getCount  @return Count
	 * getvoteReceived       @return voteReceived
	 * getPoliticalParty()   @return politicalParty()
	
	 * 
	 */
	public int getCount() {
		return voteRecieved;
	}

	public int getvoteReceived() {
		return voteRecieved;
	}
	public String getPoliticalParty() {
		return politicalparty;
	}
	
	// Increase Vote method
	public void increaseCount() {
		voteRecieved++;
	}

	public void increaseCount(int votesReceived) {
		voteRecieved += votesReceived;
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
		return voteRecieved == other.voteRecieved && Objects.equals(politicalparty, other.politicalparty)
				&& voteRecieved == other.voteRecieved;
	}

	
	


@Override
	public String toString() {
		return 	"CandidateName: "+getFullname()+"\n"+
				"Candidate voteReceived=" + voteRecieved + "\n"+
				"Politicalparty=" + politicalparty + "\n"
				;
	}

@Override 
//Hashcode method
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + Objects.hash(politicalparty, voteRecieved);
	return result;
}

public static void main(String[] args) {
	Candidate nana=new Candidate("Nana", "12/01/2002", "Ghana", 'M', 212121, "NPP");
	Candidate mahama=new Candidate("Mahama", "12/01/2002", "Ghana", 'M', 2133321, "NDC");
	System.out.println(nana.hashCode());
	System.out.println(mahama.hasVote());
}

}



