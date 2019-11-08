package com.gdin.dzzwsyb.zzbxxbspt.web.model;

public class Permission {
    private Integer permId;

    private String permName;

    private String permSign;

    private String permDesc;

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getPermName() {
        return permName;
    }

    public void setPermName(String permName) {
        this.permName = permName == null ? null : permName.trim();
    }

    public String getPermSign() {
        return permSign;
    }

    public void setPermSign(String permSign) {
        this.permSign = permSign == null ? null : permSign.trim();
    }

    public String getPermDesc() {
        return permDesc;
    }

    public void setPermDesc(String permDesc) {
        this.permDesc = permDesc == null ? null : permDesc.trim();
    }
}