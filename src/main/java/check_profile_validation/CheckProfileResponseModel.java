package check_profile_validation;

import entity.RelativeRelation;

import java.util.List;
import java.util.UUID;

public class CheckProfileResponseModel {
    private final CheckProfileGateway gateway;
    private String fileType;
    private int visualLevel;
    private String name;
    private List<Object> list1;
    private String list1Name;
    private List<Object> list2;
    private String list2Name;
    private Integer uid;
    private UUID oid;
    private Integer relation;

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

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }
}
