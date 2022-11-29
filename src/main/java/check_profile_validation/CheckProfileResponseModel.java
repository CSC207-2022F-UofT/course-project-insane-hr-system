package check_profile_validation;

import entity.RelativeRelation;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckProfileResponseModel {
    private final CheckProfileGateway gateway;
    private String fileType;
    private int visualLevel;
    private String name;
    private List<Object> list1 = new ArrayList<>();
    private Object[] reference1;
    private String list1Name;
    private List<Object> list2 = new ArrayList<>();
    private Object[] reference2;
    private String list2Name;
    private Integer uid;
    private UUID oid;
    private RelativeRelation relation;
    private String bio;

    public CheckProfileResponseModel(CheckProfileGateway gateway) {
        this.gateway = gateway;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getVisualLevel() {
        return visualLevel;
    }

    public void setVisualLevel(int visualLevel) {
        this.visualLevel = visualLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getList1() {
        return list1;
    }

    public void setList1(List<Object> list1) {
        this.list1 = list1;
    }

    public List<Object> getList2() {
        return list2;
    }

    public void setList2(List<Object> list2) {
        this.list2 = list2;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public UUID getOid() {
        return oid;
    }

    public void setOid(UUID oid) {
        this.oid = oid;
    }

    public String getList1Name() {
        return list1Name;
    }

    public void setList1Name(String list1Name) {
        this.list1Name = list1Name;
    }

    public String getList2Name() {
        return list2Name;
    }

    public void setList2Name(String list2Name) {
        this.list2Name = list2Name;
    }

    public CheckProfileGateway getGateway() {
        return gateway;
    }

    public RelativeRelation getRelation() {
        return relation;
    }

    public void setRelation(RelativeRelation relation) {
        this.relation = relation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Object[] getReference1() {
        return reference1;
    }

    public void setReference1(Object[] reference1) {
        this.reference1 = reference1;
    }

    public Object[] getReference2() {
        return reference2;
    }

    public void setReference2(Object[] reference2) {
        this.reference2 = reference2;
    }
}
