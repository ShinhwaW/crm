package cn.shinhwa.crm.web.interceptor;

import cn.shinhwa.crm.domain.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

public class PrivilegeInterceptor extends MethodFilterInterceptor {
    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

        User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if (loginUser == null) {
            ActionSupport actionSupport = (ActionSupport) actionInvocation.getAction();
            actionSupport.addActionError("Please login first!!!");
            return "login";
        }else {
            return actionInvocation.invoke();
        }
    }
}
