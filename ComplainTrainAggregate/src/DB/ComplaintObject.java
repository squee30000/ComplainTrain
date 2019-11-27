package DB;
import java.util.ArrayList;
import java.util.List;

public class ComplaintObject {

    private String complaintBody;
    private List<ComplaintTags> tags;

    public ComplaintObject(){
        tags = new ArrayList<ComplaintTags>();
    }

    public void addBody(String body){complaintBody = body;}

    public void addTag(ComplaintTags tag){tags.add(tag);}

}
