import java.util.HashMap;

public interface Collatable {
    HashMap<Candidate, Integer> voteResults = new HashMap<Candidate, Integer>();

    public HashMap<Candidate, Integer> collateResults(HashMap<Candidate, Integer> votes);
    
}