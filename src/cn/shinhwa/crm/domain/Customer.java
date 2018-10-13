package cn.shinhwa.crm.domain;

public class Customer {
    /*
  `cust_id` BIGINT(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
  `cust_name` VARCHAR(32) NOT NULL COMMENT '客户名称(公司名称)',
  `cust_source` VARCHAR(32) DEFAULT NULL COMMENT '客户信息来源',
  `cust_industry` VARCHAR(32) DEFAULT NULL COMMENT '客户所属行业',
  `cust_level` VARCHAR(32) DEFAULT NULL COMMENT '客户级别',
  `cust_phone` VARCHAR(64) DEFAULT NULL COMMENT '固定电话',
  `cust_mobile` VARCHAR(16) DEFAULT NULL COMMENT '移动电话',
     */

    private Long cust_id;
    private String cust_name;
//    private String cust_source;
//    private String cust_industry;
//    private String cust_level;
    private String cust_phone;
    private String cust_mobile;
    private String cust_img;

    private BaseDict baseDictSource;
    private BaseDict baseDictIndustry;
    private BaseDict baseDictLevel;

    public Customer(Long cust_id, String cust_name, String cust_phone, String cust_mobile, BaseDict baseDictSource, BaseDict baseDictIndustry, BaseDict baseDictLevel) {
        this.cust_id = cust_id;
        this.cust_name = cust_name;
        this.cust_phone = cust_phone;
        this.cust_mobile = cust_mobile;
        this.baseDictSource = baseDictSource;
        this.baseDictIndustry = baseDictIndustry;
        this.baseDictLevel = baseDictLevel;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public BaseDict getBaseDictSource() {
        return baseDictSource;
    }

    public void setBaseDictSource(BaseDict baseDictSource) {
        this.baseDictSource = baseDictSource;
    }

    public BaseDict getBaseDictIndustry() {
        return baseDictIndustry;
    }

    public void setBaseDictIndustry(BaseDict baseDictIndustry) {
        this.baseDictIndustry = baseDictIndustry;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }

    public String getCust_img() {
        return cust_img;
    }

    public void setCust_img(String cust_img) {
        this.cust_img = cust_img;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                ", baseDictSource=" + baseDictSource +
                ", baseDictIndustry=" + baseDictIndustry +
                ", baseDictLevel=" + baseDictLevel +
                '}';
    }
}
