package models;

public class MembershipRequestModel {
    private int id;
    private int studentid;
    private String membershipType;
    private boolean isApproved;


    public MembershipRequestModel(int id, int studentId, String membershipType, boolean isApproved) {
        this.id = id;
        this.studentid = studentId;
        this.membershipType = membershipType;
        this.isApproved = isApproved;
    }

    public MembershipRequestModel(int studentId, String membershipType, boolean isApproved) {
        this.studentid= studentId;
        this.membershipType = membershipType;
        this.isApproved = isApproved;
    }

    public int getStudentId() {
        return studentid;
    }

    public void setStudentId(int studentId) {
        this.studentid = studentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
