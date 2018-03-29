package action;

import bean.Item;
import bean.dao.CartManager;
import bean.dao.GoodsDAO;
import bean.vo.GoodsVo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;

public class CartAction extends ActionSupport{






    private String action;
    private String quantity;
    private String goodsId;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }


    public String addToCart(){


        String goodsId = this.getGoodsId();
        CartManager cartManager = new CartManager();


        ArrayList<Item> cart = (ArrayList<Item>)ActionContext.getContext().getSession().get("cart");
        if(cart != null){
            cartManager.setCart(cart);
            cartManager.addToCart(goodsId, 1);
        }else{
            cart = new ArrayList<Item>();
            cartManager.setCart(cart);
            cartManager.addToCart(goodsId, 1);
        }

        ActionContext.getContext().getSession().put("cart", cartManager.getCart());




        return SUCCESS;

    }




    public String modifyGoods(){
//		System.out.println(goodsId);



        int quantity = Integer.parseInt(this.getQuantity());
        String goodsId = this.getGoodsId();

        ArrayList<Item> cart = (ArrayList<Item>)ActionContext.getContext().getSession().remove("cart");
        CartManager cartManager = new CartManager();

//		System.out.println(goodsId);

            cartManager.setCart(cart);
            cartManager.update(goodsId, quantity);


        ActionContext.getContext().getSession().put("cart", cartManager.getCart());







        return SUCCESS;






    }


    public String clearCart(){

        ActionContext.getContext().getSession().remove("cart");

        return SUCCESS;

    }

    public String delete(){

        String goodsId = this.getGoodsId();

        ArrayList<Item> cart = (ArrayList<Item>)ActionContext.getContext().getSession().remove("cart");
        CartManager cartManager = new CartManager();

//		System.out.println(goodsId);

        cartManager.setCart(cart);
        cartManager.delete(goodsId);

        ActionContext.getContext().getSession().put("cart", cartManager.getCart());

        return SUCCESS;

    }





}
