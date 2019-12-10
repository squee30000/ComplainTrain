package DB;
import java.util.ArrayList;
import java.util.List;

public class ComplaintObject {

    private String complaintBody;
    private List<ComplaintTags> tags;
    private String department;
    private String name;

    public ComplaintObject(){
        tags = new ArrayList<ComplaintTags>();
    }
    public void addInfo(String body, String dept) {
    	complaintBody = body;
    	department = dept;
    }
    public void addInfoName(String n, String b, String d) {
    	name = n;
    	complaintBody = b;
    	department = d;
    }
    public void addTag(ComplaintTags tag){tags.add(tag);}
    
}
