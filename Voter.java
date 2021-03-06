import java.util.Objects;

public class Voter {
	private String fullname;
	private String dateofbirth;
	private String nationality;
	private char gender;
	private int voterid;
	protected boolean vote;
	
	Voter(String fullname,String dateofbirth,String nationality,char gender,int voterid){
		this.fullname=fullname;
		this.dateofbirth=dateofbirth;
		this.nationality=nationality;
		this.gender=gender;
		this.voterid=voterid;
		
}
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
	
	
	
	/** toString method
    *
    * @return dob,nationality,gender,voterid,vote,
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

   /**
    * equals method
    * @param o
    * @return
    */
   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Voter)) return false;
       Voter voter = (Voter) o;
       return getGender() == voter.getGender() && Objects.equals(getFullname(), voter.getFullname()) && Objects.equals(getNationality(), voter.getNationality());
   }

   /**
    * hashcode
    * @return
    */
   @Override
   public int hashCode() {
       return Objects.hash(getFullname(), getNationality(), getGender());
   }
  public boolean hasVote() {
	  if(vote==true)
		  
	return true;
	return vote;
  }
   /*Vote method
    * @param vote
     
   public boolean Vote(Candidate count) {
	   if(vote==true) {
		   count=count+1;
		return hasVote();
		   }
	   return false;
   }
 */  
   public boolean Voted(int count) {
	   if(vote==true) {
		   count=count+1;
		return hasVote();
		   }
	   count=count-1;
	   return false;
   }


}
