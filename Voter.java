import java.util.Objects;

/*
 *
 * Class: Voter
 * Access Modifier: Public
 * 
 */

public class Voter {
	
	/*
	 * Instance Variables
	 * @fullname
	 * @dateofbirth
	 * @nationality
	 * @gender
	 * @voterid
	 * @vote
	 */
	private String fullname;
	private String dateofbirth;
	private String nationality;
	private char gender;
	private int voterid;
	protected boolean vote;
	
	/*
	 *  Constructor
	 * @param fullname
	 * @param dateofbirth
	 * @param nationality
	 * @param gender
	 * @param voterid
	 * 
	 */
	Voter(String fullname,String dateofbirth,String nationality,char gender,int voterid){
		this.fullname=fullname;
		this.dateofbirth=dateofbirth;
		this.nationality=nationality;
		this.gender=gender;
		this.voterid=voterid;	
	}


	
	/*
	 * Accessor Method 
	 * getFullname  @return fullname
	 * getDOB       @return dateofbirth
	 * getNationality   @return nationality
	 * getGender       @return gender
	 * getVoterId      @return voterid
	 * 
	 */
	
	public String getFullname() {
		return fullname;
	}
	
	public String getDateOfBirth() {
		return dateofbirth;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public char getGender() {
		return gender;
	}
	
	public int getVoterId() {
		return voterid;
	}
	

	/*
	 * Mutator methods : 
	 * setFullname  @param fullname
	 * setDOB       @param dateofbirth
	 * setNationality   @param nationality
	 * setGender      @param gender
	 * setVoterId      @param voterid)
	 */
	public void setFullname(String fullname) {
		this.fullname=fullname;
	}
	public void setDOB(String dateofbirth) {
		this.dateofbirth=dateofbirth;
	}
	
	public void setNationality(String nationality) {
		this.nationality=nationality;
	}
	
	public void setGender(char gender) {
		this.gender=gender;
	}
	
	public void setVoterId(int voterid) {
		this.voterid=voterid;
	}
	
	
	/*
	 * setVote @param vote
	 * getVote return vote
	 */
	public void setVote(boolean vote) {
		this.vote=vote; 
	}
	
	public boolean getVote() {
		return vote;
	}
	
	
	
	
	/* toString method
    *
    * @return dob,nationality,gender,voterid
    */
   @Override
   public String toString() {
       return "Voter Details \n " +
               "fullname :'" + getFullname() + "\n"+
               " DateOfBirth :'" + getDateOfBirth() + "\n" +
               "nationality :" + getNationality() + "\n" +
               " gender: " + getGender() + "\n"+
               " voterid: " + getVoterId();
               
               }

   /*
    * equals method
    * @param obj
    * @return
    */
   @Override
   public boolean equals(Object obj) {
       if (this == obj) return true;
       if (!(obj instanceof Voter)) return false;
       Voter voter = (Voter) obj;
       return getGender() == voter.getGender() && Objects.equals(getFullname(), voter.getFullname()) && Objects.equals(getNationality(), voter.getNationality());
   }

   /*
    * hashcode
    * @return
    */
   @Override
   public int hashCode() {
       return Objects.hash(getFullname(), getNationality(), getGender());
   }
   
   

	
	
	// Has vote method
  public boolean hasVote() {
	return vote;
  }
   
  
  /*Vote method
   * @param vote
   * */
   public void Vote(Candidate candidate) {
	   if(hasVote())
	    throw new IllegalStateException(" You have voted already!");
	   //NationalElectorialOffice.candidateList.get(candidate.getVoterId()).increaseCount();
	   candidate.increaseCount();
	   vote=true;
	}


	public static void main(String[] args) {
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
		Candidate nana=new Candidate("Nana", "12/01/2002", "Ghana", 'M', 212121, "NPP");
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
		
		// v1.Vote(nana);
		// System.out.println(v1.hasVote());
		// System.out.println(nana.getvoteReceived());

	}
	      
}




