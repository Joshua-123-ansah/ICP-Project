import java.util.HashMap;

public interface Collatable {
    HashMap voteResults = new HashMap<Candidate, Integer>();

    public HashMap collateResults(HashMap votes);
    
}