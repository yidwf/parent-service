package com.yesido.rpc.dto;

import java.util.List;

public class GroupDetailDto {

    private String id; // 群ID

    private String name; // 群名

    private String owner; // 群主

    private GroupMember ownerDetail;

    private Integer memberCount; // 群人数

    private List<GroupMember> members; // 群成员，含群主

    private int type; // 群组类型, 1=普通聊天群

    private String createTime;

    private long createTimeMillis; //创建时间毫秒值

    private String icon; // 群图标

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public GroupMember getOwnerDetail() {
        return ownerDetail;
    }

    public void setOwnerDetail(GroupMember ownerDetail) {
        this.ownerDetail = ownerDetail;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public List<GroupMember> getMembers() {
        return members;
    }

    public void setMembers(List<GroupMember> members) {
        this.members = members;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getCreateTimeMillis() {
        return createTimeMillis;
    }

    public void setCreateTimeMillis(long createTimeMillis) {
        this.createTimeMillis = createTimeMillis;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

}


class GroupMember {
    private String account;

    private String name;

    private String icon;

    private String joinTime;

    private Long joinTimeMillis;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime;
    }

    public Long getJoinTimeMillis() {
        return joinTimeMillis;
    }

    public void setJoinTimeMillis(Long joinTimeMillis) {
        this.joinTimeMillis = joinTimeMillis;
    }

}


