package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MyLoginAction extends ActionSupport{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    @Override
    public String execute() throws Exception {
        String username=this.getUsername();
        String password=this.getPassword();

        ActionContext.getContext().getSession().put("username", username);
        ActionContext.getContext().getSession().put("password", password);


        if(username.equals("qtech")&&password.equals("java")){


            return SUCCESS;
        }
        

       else return ERROR;

    }
}
