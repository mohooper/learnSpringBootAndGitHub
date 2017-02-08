package com.test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.test.service.UserService;
import com.test.util.XmlUtils;

@Service
public class UserServiceImpl implements UserService{

	public List<Map> userList(HttpServletRequest request) {
		
		//查询集
		List<Map> data = XmlUtils.selectXML("src/main/resources/dataxml/users.xml");
		
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
			XmlUtils.updateXML("src/main/resources/dataxml/users.xml", id, userName, userCode, userGender, userMobile, userAddress, userRemark);
		}else{
			XmlUtils.addXML("src/main/resources/dataxml/users.xml", userName, userCode, userGender, userMobile, userAddress, userRemark);
		}
	}

	@Override
	public void userDel(String ids) {
		if(StringUtils.isNotBlank(ids)){
			for(String id:ids.split(",")){
				if(StringUtils.isBlank(id))continue;
				XmlUtils.deleteXML("src/main/resources/dataxml/users.xml", id);
			}
		}
		
	}

	
}
