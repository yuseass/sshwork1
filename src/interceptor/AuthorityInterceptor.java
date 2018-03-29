package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class AuthorityInterceptor
        extends AbstractInterceptor
{
    // 拦截Action处理的拦截方法
    public String intercept(ActionInvocation invocation)
            throws Exception
    {
        // 取得请求相关的ActionContext实例
        ActionContext ctx = invocation.getInvocationContext();
        Map session = ctx.getSession();
        // 取出Session里的user属性
        String user = (String)session.get("username");
        //如果没有登录，或者登录所用的用户名不是crazyit.org，都返回重新登录
        if (user != null && user.equals("qtech") )
        {
            return invocation.invoke();
        }
        // 如果没有登录，将服务器提示放入ActionContext中
       else {
            ctx.put("tip", "您还没有登录，请使用qtech登录");
            // 返回login的逻辑视图
            return Action.LOGIN;
        }
    }
}
