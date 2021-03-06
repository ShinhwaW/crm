package cn.shinhwa.crm.web.action;

import cn.shinhwa.crm.domain.Customer;
import cn.shinhwa.crm.domain.PageBean;
import cn.shinhwa.crm.service.CustomerService;
import cn.shinhwa.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;
import java.io.IOException;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
    private Customer customer = new Customer();

    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private Integer currPage = 1;

    public void setCurrPage(Integer currPage) {
        if (currPage == null) {
            currPage = 1;
        }
        this.currPage = currPage;
    }

    private Integer pageSize = 3;

    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 3;
        }
        this.pageSize = pageSize;
    }

    /*
        文件上传的三个属性
     */

    private String uploadFileName;
    private File upload;
    private String uploadContentType;

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    public String saveUI() {
        return "saveUI";
    }


    public String save() throws IOException {
        if (upload != null) {
            String path = "E:/workspace_idea/upload";
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            String realPath = UploadUtils.getPath(uuidFileName);
            String url = path + realPath;
            File file = new File(url);
            if (!file.exists()){
                file.mkdirs();
            }
            //文件上传
            File dictFile = new File(url + "/" + uuidFileName);
            FileUtils.copyFile(upload,dictFile);
            customer.setCust_img(url + "/" + uuidFileName);
        }
        customerService.save(customer);
        return "saveSuccess";
    }

    public String findAll() {
        // 接收参数：分页参数
        // 最好使用DetachedCriteria对象（条件查询--带分页）
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        // 设置条件：（在web层设置条件）
        if (customer.getCust_name() != null) {
            // 输入名称:
            detachedCriteria.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
        }
        if (customer.getBaseDictSource() != null) {
            if (customer.getBaseDictSource().getDict_id() != null
                    && !"".equals(customer.getBaseDictSource().getDict_id())) {
                detachedCriteria
                        .add(Restrictions.eq("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
            }

        }
        if (customer.getBaseDictLevel() != null) {
            if (customer.getBaseDictLevel().getDict_id() != null
                    && !"".equals(customer.getBaseDictLevel().getDict_id())) {
                detachedCriteria
                        .add(Restrictions.eq("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
            }
        }
        if (customer.getBaseDictIndustry() != null && customer.getBaseDictIndustry().getDict_id() != null) {
            if (customer.getBaseDictIndustry().getDict_id() != null
                    && !"".equals(customer.getBaseDictIndustry().getDict_id())) {
                detachedCriteria
                        .add(Restrictions.eq("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
            }
        }
        // 调用业务层查询:
        PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, currPage, pageSize);
        ActionContext.getContext().getValueStack().push(pageBean);
        return "findAll";
    }

    public String delete() {
        //先查询在删除,因为要删除级联信息或者是文件信息等其他信息,需要从其他属性获取删除的对象
        customer = customerService.findByCustId(customer.getCust_id());
        if (customer.getCust_img() != null){
            File file = new File(customer.getCust_img());
            if (file.exists()){
                file.delete();
            }
        }
        customerService.delete(customer);
        return "deleteSuccess";
    }

    public String edit() {
        customer = customerService.findByCustId(customer.getCust_id());
        System.out.println(customer.toString());
        // 将customer传递到页面：
        // 两种方式：一种，手动压栈。二种，因为模型驱动的对象，默认在栈顶。
        // 如果使用第一种方式：回显数据: <s:property value="cust_name"/> <s: name="cust_name"
        // value="">
        // 如果使用第二种方式：回显数据: <s:property value="model.cust_name"/>
        // ActionContext.getContext().getValueStack().push(customer);
        // 跳转页面

        return "editSuccess";
    }

    public  String update() throws IOException {
        if (upload != null) {
            String cust_img = customer.getCust_img();
            if (cust_img != null || !"".equals(cust_img)){
                File file =new File(cust_img);
                file.delete();
            }
            String path = "E:/workspace_idea/upload";
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            String realPath = UploadUtils.getPath(uuidFileName);
            String url = path + realPath;
            File file = new File(url);
            if (!file.exists()){
                file.mkdirs();
            }
            //文件上传
            File dictFile = new File(url + "/" + uuidFileName);
            FileUtils.copyFile(upload,dictFile);
            customer.setCust_img(url + "/" + uuidFileName);
        }
        customerService.update(customer);
        return "updateSuccess";
    }

}
