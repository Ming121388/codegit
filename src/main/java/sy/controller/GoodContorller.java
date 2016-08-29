package sy.controller;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.ibatis.annotations.Param;
import sy.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSONArray;

import sy.model.Good;
import sy.service.GoodServiceI;
import sy.service.GoodServiceImpl;
import sy.service.UserServiceI;
@Controller
@RequestMapping("/goodController")
public class GoodContorller {
	private GoodServiceI goodService;

	public GoodServiceI getGoodService() {
		return goodService;
	}
	@Autowired
	public void setGoodService(GoodServiceI goodService) {
		this.goodService = goodService;
	}
	
	@RequestMapping("/showGoods")
	public @ResponseBody String[][] showGood(HttpServletRequest request,HttpServletResponse response){
		//public @ResponseBody List<String> showGood(HttpServletRequest request,HttpServletResponse response){
		//Map<String ,Object> map = new HashMap<String , Object>(); 
		Good g=new Good();
		//List<String> li=new ArrayList<String>();
		//String[][] str = {{"",""},{"",""}};
		
		List<Good> list = goodService.getAll();
		Iterator<Good> it = list.iterator();
		String[][] str =new String[list.size()][list.size()];
		System.out.println(list.size());
		int i=0;
		while(it.hasNext()){
			g=it.next();
			//map.put(i, "商品名"+g.getGoodname()+"价格:"+g.getGoodprice());
			//li.add(g.getGoodname()+"--------"+g.getGoodprice()+"￥");
			str[i][0]=g.getGoodname();
			str[i][1]=String.valueOf(g.getGoodprice());
			System.out.println(i+" "+str[i][0]+"  "+str[i][1]);
			i++;
			}
		return str;
		//map.put("a", "aa");
		//return map;
	}
	
	@RequestMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(@RequestParam("pic")CommonsMultipartFile pic,HttpServletRequest request,HttpServletResponse response
			)throws IOException{
		//设置文件保存的本地路径

		String filePath = request.getSession().getServletContext().getRealPath("E:");

		String fileName = pic.getOriginalFilename();

		String fileType = fileName.split("[.]")[1];

		//为了避免文件名重复，在文件名前加UUID

		String uuid = UUID.randomUUID().toString().replace("-","");

		String uuidFileName = uuid + fileName;

		File f = new File(filePath+"/"+uuid+"."+fileType);

		//将文件保存到服务器

		FileUtil.upFile(pic.getInputStream(), uuidFileName, filePath);

		return uuidFileName;


	}
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request ,HttpServletResponse response){
	//	request.setAttribute(, arg1);
		return "addGoods";
		
	}

}
