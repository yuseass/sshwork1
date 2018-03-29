package action;

import bean.dao.GoodsDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetAllGoodsAction extends ActionSupport{
    private String pageNo;

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageNo() {
        return pageNo;
    }


    @Override
    public String execute() throws Exception {




        String pageNo = this.getPageNo();
        int page = 1;
        if(pageNo != null){
            page = Integer.parseInt(pageNo);
        }

        GoodsDAO goodsDAO = new GoodsDAO();
        ArrayList goodsList = goodsDAO.getGoodsByPage(page);
        int pageCount = goodsDAO.getPageCount();

        ActionContext.getContext().getSession().put("goodsList", goodsList);
        ActionContext.getContext().getSession().put("pageNo", page);
        ActionContext.getContext().getSession().put("pageCount", pageCount);

       return SUCCESS;


    }
}
