package bean.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.DBBean;
import bean.vo.GoodsVo;

public class GoodsDAO {
	public ArrayList getGoodsByPage(int pageNo){
		int numPerPage = 2;
		
		ArrayList rst = new ArrayList();
		
		String sql = "select * from goods";
		
		DBBean db = new DBBean();
		Connection con = db.getConnection();
		ResultSet rs = null;
		
		try {
			 rs = db.executeQuery(sql, null);
			 
			 if(rs != null){
				int index = 1;
				int beginIndex = (pageNo - 1)*numPerPage+1;
				int endIndex = pageNo * 2;
						
				while(rs.next()){
					if(index < beginIndex){
						index ++;
						continue;
					}
						
					if(index > endIndex){
						index ++;
						break;
					}
						
					String goodsId = rs.getString(1);
					String goodsName = rs.getString(2);
					Float price = rs.getFloat(3);
					
					GoodsVo g = new GoodsVo();
					g.setGoodsId(goodsId);
					g.setGoodsName(goodsName);
					g.setPrice(price);
					
					rst.add(g);
					index ++;
				}
			}
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rst;
	}
	
	
	public GoodsVo getGoodsById(String goodsId){
		GoodsVo g = null;
		
		ArrayList rst = new ArrayList();
		
		String sql = "select * from goods where goodsid=?";
		ArrayList params = new ArrayList();
		params.add(goodsId);
		
		DBBean db = new DBBean();
		Connection con = db.getConnection();
		ResultSet rs = null;
		
		try {
			 rs = db.executeQuery(sql, params);
			 
			 if(rs != null){
						
				rs.next();
						
				String goodsId_ = rs.getString(1);
				String goodsName = rs.getString(2);
				Float price = rs.getFloat(3);
					
				g = new GoodsVo();
				g.setGoodsId(goodsId_);
				g.setGoodsName(goodsName);
				g.setPrice(price);
					
		     }
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return g;
	}

	public int getPageCount(){
		int rst = 0;
		DBBean db = new DBBean();
		Connection con = db.getConnection();
		String sql = "select count(*) from goods";
		try {
			ResultSet rs = db.executeQuery(sql,null);
			
			String count = null;
			if(rs.next())
				 count = rs.getString(1);
			
			rst = Integer.parseInt(count);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (rst-1)/2+1;
		
	}


}
