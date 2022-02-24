package org.example.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id

    private int id;



    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    //@ElementCollection
    //@OrderColumn
//    @CollectionTable(name="image", //defaults to student_images
//            joinColumns = @JoinColumn(name="student_id"))
//    @MapKeyColumn(name="file_name")
//    @Column(name = "image_name")
    //@Column(name="file_name") //defaults to images
    //LIST
    //private List<String> images = new ArrayList<String>();
    //MAP
    //private Map<String, String> images=new HashMap<String, String>();

    public Student(Integer id, String firstName, String lastName, String email) {
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public Student() {

    }

//    public Student(Address studentAddress) {
//        this.studentAddress = studentAddress;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


//    public Map<String,String> getImages() {
//        return images;
//    }
//
//    public void setImages(Map<String,String> images) {
//        this.images = images;
//    }
    @Embedded
    private Address studentAddress;
    public Address getStudentAddress(){
        return this.studentAddress;
    }
    public void SetStudentAddress(Address studentAddress){
        this.studentAddress=studentAddress;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address="+studentAddress+"]";
    }

}
