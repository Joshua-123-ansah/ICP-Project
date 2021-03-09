package ICP_Final_Project;

public class MainTestingCenter {

	
	public static void main(String arg[]) {
		
		Voter v1=new Voter("Joshua", "04/01/2002", "Ghanaian", 'M', 12345);
		Voter v2=new Voter("David", "04/01/2002", "Nigerian", 'M',12347);
		Voter v3=new Voter("Gadzi", "04/01/2002", "Ghanaian", 'M', 12343);
		Voter v4=new Voter("Ayeyi", "04/01/2002", "Nigerian", 'M',12349);
		Voter v5=new Voter("Clara", "04/01/2002", "Ghanaian", 'M', 12340);
		Voter v6=new Voter("MyBaby", "04/01/2002", "Nigerian", 'M',12342);
		Voter v7=new Voter("I love You", "04/01/2002", "Ghanaian", 'M',12341);
		Voter v8=new Voter("So Much Jesus", "04/01/2002", "Nigerian", 'M',57392023);
		Voter v9=new Voter("Joshua", "04/01/2002", "Ghanaian", 'M', 145);
		Voter v10=new Voter("David", "04/01/2002", "Nigerian", 'M',127);
		Voter v11=new Voter("Gadzi", "04/01/2002", "Ghanaian", 'M', 143);
		Voter v12=new Voter("Ayeyi", "04/01/2002", "Nigerian", 'M',129);
		Voter v13=new Voter("Clara", "04/01/2002", "Ghanaian", 'M', 1240);
		Voter v14=new Voter("MyBaby", "04/01/2002", "Nigerian", 'M',1342);
		Voter v15=new Voter("I love You", "04/01/2002", "Ghanaian", 'M',141);
		Voter v16=new Voter("So Much Jesus", "04/01/2002", "Nigerian", 'M',57393);
//		System.out.println(v1.toString());
//		System.out.println(v1.equals(v2));
		
		Candidate nana=new Candidate("Nana", "12/01/203", "Ghana", 'M', 212121, "NPP");
		Candidate mahama=new Candidate("Mahama", "12/02/2002", "Niger", 'M', 111111, "NDC");
		Candidate m=new Candidate("Linda", "12/02/202", "Nigera", 'M', 1111, "NPC");
		
	//	System.out.println(nana.equals(mahama));
		
		PollingStation pp1=new PollingStation("Ayawaso", 1223, "Ayawaso Dis", "Ashanti");
	    PollingStation pp2=new PollingStation("Dodowu", 3423, "Ay Dis", "Ashanti");
	    PollingStation pp3=new PollingStation("Dodou", 343, "Ay Dis", "Ashanti");

	    DistrictOffice dis=new DistrictOffice("Ayawaso", 122, "GA", 12);
	    DistrictOffice dis2=new DistrictOffice("Ayaso", 12, "GA", 11);
	    
	    RegionalOffice rg = new RegionalOffice("Western", 555, 200);
	    
	    NationalElectorialOffice hq = new NationalElectorialOffice("Hq", 011112323, "GA");

		v1.Vote(m, pp1);
		v2.Vote(mahama, pp1);
		v3.Vote(mahama, pp1);
		v4.Vote(nana, pp2);
		v5.Vote(m, pp3);
		v6.Vote(nana, pp1);
		v7.Vote(nana, pp1);
		v8.Vote(m, pp3);
		v9.Vote(nana, pp2);
		v10.Vote(mahama, pp2);
		v11.Vote(m, pp3);
		v12.Vote(nana, pp2);
		v13.Vote(nana, pp2);
		v14.Vote(m, pp3);
		v15.Vote(nana, pp2);
		v16.Vote(nana, pp2);
      
		
    	System.out.println("nana: "+nana.getVoteReceived());
		System.out.println("Mahama: "+mahama.getVoteReceived());
		
		System.out.println(pp1.getTotalVoteCast());
		pp1.eachCandidateVoteAtThisOfficeLevel(mahama);
		pp1.eachCandidateVoteAtThisOfficeLevel(nana);
		System.out.println(pp1.collatedResults());
		
		System.out.println(pp1.equals(pp1));
		
		pp1.reportCandidateResultToDistrict(dis);
		pp2.reportCandidateResultToDistrict(dis2);
		pp3.reportCandidateResultToDistrict(dis);
		
		
		
		System.out.println(dis.eachCandidateVoteAtThisOfficeLevel(mahama));
		System.out.println(dis.eachCandidateVoteAtThisOfficeLevel(nana));
		System.out.println(dis.eachCandidateVoteAtThisOfficeLevel(m));
				
		System.out.println(dis.getTotalVoteCast());
		
		
		
		System.out.println();
		System.out.println();
		
		dis.reportResults(rg);
		dis2.reportResults(rg);
		
		rg.reportToNationalOffice(hq);
		
		System.out.println(rg.eachCandidateVoteAtThisOfficeLevel(mahama));
		
		System.out.println(hq.eachCandidateVoteAtThisOfficeLevel(nana));
		
		System.out.println(hq);
		
		
	}


}
