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
        department = dept;
        //String dept1[] = department.split(" ");
               
        
    }
    public ComplaintObject(String complaint, String dept){
        tags = new ArrayList<ComplaintTags>();
        complaintBody = complaint;
        department = dept;
        //String dept2[] = dept.split(" ");
       
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
    
    public String getName() {
    	return name;
    }
    public String getDepartment() {
    	return department;
    }
    public String getText() {
    	return complaintBody;
    }
    
}
