package com.etcxm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etcxm.dao.ProductDao;
import com.etcxm.dao.ProductDirDao;
import com.etcxm.entity.Product;
import com.etcxm.entity.ProductDir;
import com.etcxm.entity.ProductQueryObject;
import com.etcxm.page.PageResult;
import com.etcxm.utils.StringUtils;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductDao dao = new ProductDao();
	private ProductDirDao dirDao = new ProductDirDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");

		String parameter = req.getParameter("cmd");
		if(StringUtils.hasLength(parameter)){
			if (parameter.equals("delete")) {
				// delete(req, resp);
			} else if (parameter.equals("edit")) {
				// edit(req, resp);
			} else if (parameter.equals("saveOrUpdate")) {
				// saveOrUpdate(req, resp);
			} else {
				list(req, resp);
			}
		}else{
			list(req, resp);
		}
		
	}

	protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//登录校验
		Object object = req.getSession().getAttribute("USER_IN_SESSION");
		if(object==null){
			resp.sendRedirect("/Day16_page/Login/login.jsp");
			return;
		}
		
		String productName = req.getParameter("productName");
		String minPriceStr = req.getParameter("minPrice");
		String maxPriceStr = req.getParameter("maxPrice");
		String dir_idStr = req.getParameter("dir_id");
		
		
		String pageSize = req.getParameter("pageSize");
		//System.out.println("dddddd"+pageSize);
		String currentPage = req.getParameter("currentPage");
		
		
		try {
			ProductQueryObject op = new ProductQueryObject();
			op.setProductName(productName);
			if(StringUtils.hasLength(minPriceStr)){
				op.setMinPrice(Double.valueOf(minPriceStr));
			}
			if(StringUtils.hasLength(maxPriceStr)){
				op.setMaxPrice(Double.valueOf(maxPriceStr));
			}
			if(StringUtils.hasLength(dir_idStr)){
				op.setDir_id(Long.valueOf(dir_idStr));
			}
			Integer icurrentPage = 1;
			if(StringUtils.hasLength(currentPage)){
				icurrentPage = Integer.valueOf(currentPage);
				op.setCurrentPage(icurrentPage);
			}
			
			Integer ipageSize = 3;
			if(StringUtils.hasLength(pageSize)){
				ipageSize = Integer.valueOf(pageSize);
				op.setPageSize(ipageSize);
			}
			
			
			
			List<ProductDir> dirs = dirDao.queryAllproductDirs();
			//把商品分类的数据放在作用域中共享数据
			req.setAttribute("dirs", dirs);
			
			//把op对象放到作用域  共享数据
			req.setAttribute("op", op);
			// 把数据放到作用域 共享数据
			//req.setAttribute("list", products);
			PageResult result = dao.queryPageResult(op);
			req.setAttribute("pageResult", result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 3.响应请求转发
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(
				req, resp);

	}
	
	/*protected void list(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		//1.获取请求参数
		String productName = req.getParameter("productName");
		String minPriceStr = req.getParameter("minPrice");
		String maxPriceStr = req.getParameter("maxPrice");
		String dir_idStr = req.getParameter("dir_id");
		
		try {
			ProductQueryObject op = new ProductQueryObject();
			op.setProductName(productName);
			if(StringUtils.hasLength(minPriceStr)){
				op.setMinPrice(Double.valueOf(minPriceStr));
			}
			if(StringUtils.hasLength(maxPriceStr)){
				op.setMaxPrice(Double.valueOf(maxPriceStr));
			}
			if(StringUtils.hasLength(dir_idStr)){
				op.setDir_id(Long.valueOf(dir_idStr));
			}
			List<Product> products = dao.query(op);
			
			
			List<ProductDir> dirs = dirDao.queryAllproductDirs();
			//把商品分类的数据放在作用域中共享数据
			req.setAttribute("dirs", dirs);
			
			//把op对象放到作用域  共享数据
			req.setAttribute("op", op);
			// 把数据放到作用域 共享数据
			req.setAttribute("list", products);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 3.响应请求转发
		req.getRequestDispatcher("/WEB-INF/views/product/list.jsp").forward(
				req, resp);

	}*/
}
