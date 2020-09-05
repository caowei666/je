package filter;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyPermFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        String[] perms = (String[])mappedValue;
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        for (String perm:perms){
            if(subject.isPermitted(perm)){
                session.setAttribute("Allowed",true);
                return true;
            }
        }
        return false;
    }
}
