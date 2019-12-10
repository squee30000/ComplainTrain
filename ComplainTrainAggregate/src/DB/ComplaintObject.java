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
    public ComplaintObject(String name, String complaint, String dept){
        tags = new ArrayList<ComplaintTags>();
        this.name = name;
        complaintBody = complaint;
        String dept1[] = department.split(" ");
               
        //[TODO] populate tags given a string of depts
    }
    public ComplaintObject(String complaint, String dept){
        tags = new ArrayList<ComplaintTags>();
        complaintBody = complaint;
        String dept2[] = department.split(" ");
        //[TODO] populate tags given a string of depts 
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
