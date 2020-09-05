package filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;

public class MyRoleFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        String[] roles = (String[])mappedValue;
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        if(session.getAttribute("Allowed")!=null){
            return true;
        }
        for (String role:roles){
            if(subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
