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
	 * @voterrecieved
	 * @politicalparty
	 * @count
	*/
	private int voterrecieved;
	private String politicalparty;
	private int count;
	
	/*
	 *  Constructor
	 * @param fullname
	 * @param dateofbirth
	 * @param nationality
	 * @param gender
	 * @param voterid
	 * @param voterrecieved
	 * @param politicalparty
	 * 
	 */
	Candidate(String fullname,String dateofbirth,String nationality,char gender,int voterid,int voterrecieved,String politicalparty){
		super(fullname,dateofbirth,nationality, gender,voterid);
		this.voterrecieved=voterrecieved;
		this.politicalparty=politicalparty;
	}
	
	/*
	 * Mutator methods : 
	 * setVoterRecieved  @param voterrecieved
	 * setPoliticalParty       @param politicalparty
	 * setCount   @param count
	 
	 */
	public void setVoterRecieved(int voterrecieved) {
		this.voterrecieved=voterrecieved;
	}
	
	public void setPoliticalParty(String politicalparty) {
		this.politicalparty=politicalparty;
	}
	
	public void setCount(int count) {
		this.count = count;
	
	}
	
	/*
	 * Accessor Method 
	 * getCount  @return Count
	 * getVoterRecieved       @return voterRecieved
	 * getPoliticalParty()   @return politicalParty()
	
	 * 
	 */
	public int getCount() {
		return count;
	}

	public int getVoterRecieved() {
		return voterrecieved;
	}
	public String getPoliticalParty() {
		return politicalparty;
	}
	
	// Increase Vote method
	public void increaseCount() {
		count++;
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
	public String toString() {
		return "Candidate voterrecieved=" + voterrecieved + 
				", politicalparty=" + politicalparty + 
				", count=" + count
				;
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



