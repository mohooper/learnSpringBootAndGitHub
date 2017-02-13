package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.test.service.UserService;
import com.test.util.XmlUtils;

@Service
public class UserServiceImpl implements UserService{
	
//	private static String xmladd = "/Users/macbook/Documents/users.xml";
	private static String xmladd = "/home/docker_guest_1/spring-boot-maven-docker/users.xml";

	public List<Map> userList(HttpServletRequest request)throws Exception {
		
		
		//URL url = XmlUtils.getResource(UserServiceImpl.class,"dataxml/users.xml");
		
		//System.out.println(url.getPath().replace("jar:file:","").replace("file:", "").replace(".jar!", "").replace("classes!", "classes"));
		//不知道为什么会多这么多前缀，替换掉可以成功运行。。或者在本地创建一个xml文件，不放在jar包 就可以了。
        //List<Map> data = XmlUtils.selectXML(url.getPath().replace("jar:file:", "").replace("file:", "").replace(".jar!", "").replace("classes!", "classes"));
	
		
		//查询集
		List<Map> data = XmlUtils.selectXML(xmladd);
		
		//正常应该写sql条件查询，这里数据量不多就简单处理了
		
		String userName = request.getParameter("userName");
		String userMobile = request.getParameter("userMobile");
		String userAddress = request.getParameter("userAddress");
		String userGender = request.getParameter("userGender");
		
		//结果集
		List<Map> rs = new ArrayList(); 
		
		if(data!=null&&data.size()>0){
			for(Map m:data){
				String dname = (String) m.get("name");
				String dmobile = (String) m.get("mobile");
				String daddress = (String) m.get("address");
				Integer dgender = (Integer) m.get("gender");
				
				String delflag = (Integer)m.get("delflag")+"";
				if(StringUtils.isBlank(delflag)||"1".equals(delflag))continue;//删除标志
				
				//查询过滤条件
				if(StringUtils.isNotBlank(userName)&&StringUtils.isNotBlank(dname)&&dname.indexOf(userName)<0)continue;
				if(StringUtils.isNotBlank(userMobile)&&StringUtils.isNotBlank(dmobile)&&dmobile.indexOf(userMobile)<0)continue;
				if(StringUtils.isNotBlank(userAddress)&&StringUtils.isNotBlank(daddress)&&daddress.indexOf(userAddress)<0)continue;
				if(StringUtils.isNotBlank(userGender)&&dgender!=null&&!userGender.equals(dgender.toString()))continue;
				
				rs.add(m);
				
			}
		}
		
 		return rs;
 		
	}

	@Override
	public void userAddOrEdit(HttpServletRequest request) {
		
		String userName = request.getParameter("userName");
		String userCode = request.getParameter("userCode");
		String userGender = request.getParameter("userGender");
		String userMobile = request.getParameter("userMobile");
		String userAddress = request.getParameter("userAddress");
		String userRemark = request.getParameter("userRemark");
		
		String id = request.getParameter("id");
		
		if(StringUtils.isNotBlank(id)){
			XmlUtils.updateXML(xmladd, id, userName, userCode, userGender, userMobile, userAddress, userRemark);
		}else{
			XmlUtils.addXML(xmladd, userName, userCode, userGender, userMobile, userAddress, userRemark);
		}
	}

	@Override
	public void userDel(String ids) {
		if(StringUtils.isNotBlank(ids)){
			for(String id:ids.split(",")){
				if(StringUtils.isBlank(id))continue;
				XmlUtils.deleteXML(xmladd, id);
			}
		}
		
	}

	
}
