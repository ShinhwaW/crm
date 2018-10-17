package cn.shinhwa.crm.domain;

import java.util.Date;

public class SaleVisit {

    /*
  `visit_id` VARCHAR(32) NOT NULL,
  `visit_cust_id` BIGINT(32) DEFAULT NULL COMMENT '客户id',
  `visit_user_id` BIGINT(32) DEFAULT NULL COMMENT '负责人id',
  `visit_time` DATE DEFAULT NULL COMMENT '拜访时间',
  `visit_interviewee` VARCHAR(32) DEFAULT NULL COMMENT '被拜访人',
  `visit_addr` VARCHAR(128) DEFAULT NULL COMMENT '拜访地点',
  `visit_detail` VARCHAR(256) DEFAULT NULL COMMENT '拜访详情',
  `visit_nexttime` DATE DEFAULT NULL COMMENT '下次拜访时间',
     */

    private String visit_id;
//    private Long visit_cust_id;
//    private Long visit_user_id;
    private Date visit_time;
    private String visit_interviewee;
    private String visit_addr;
    private String visit_detail;
    private Date visit_nexttime;

    private Customer customer;
    private User user;

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public String getVisit_interviewee() {
        return visit_interviewee;
    }

    public void setVisit_interviewee(String visit_interviewee) {
        this.visit_interviewee = visit_interviewee;
    }

    public String getVisit_addr() {
        return visit_addr;
    }

    public void setVisit_addr(String visit_addr) {
        this.visit_addr = visit_addr;
    }

    public String getVisit_detail() {
        return visit_detail;
    }

    public void setVisit_detail(String visit_detail) {
        this.visit_detail = visit_detail;
    }

    public Date getVisit_nexttime() {
        return visit_nexttime;
    }

    public void setVisit_nexttime(Date visit_nexttime) {
        this.visit_nexttime = visit_nexttime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
