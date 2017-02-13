package com.test.util;


import java.io.File;  
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;  

import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  

import org.w3c.dom.Document;  
import org.w3c.dom.Element;  
import org.w3c.dom.Node;  
import org.w3c.dom.NodeList;  
import org.w3c.dom.Text;

import com.test.DemoApplication;
import com.test.entity.User;  
	  
public class XmlUtils {  
//    //删除节点时传入的参数  
//    private static String deleteNumber;  
//      
//    //修改节点时传入的参数  
//    private static String updateNumber;  
      
    //读取传入的路径，返回一个document对象  
    public static Document loadInit(String filePath){  
        Document document = null;  
        try{  
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder builder = factory.newDocumentBuilder();  
            //xml没有元素的时候，会报错，但不影响功能
            document = builder.parse(new File(filePath));  
            document.normalize();  
            return document;  
        }catch(Exception e){  
            e.printStackTrace();  
            System.out.println(e.getMessage());  
            return null;  
        }  
    }  
  
    /** 
     * 删除制定的xml 
     * @param filePath 
     * @return 
     */  
    public static boolean deleteXML(String filePath,String deleteNumber){  
        Document document = loadInit(filePath);  
        try{  
            NodeList nodeList = document.getElementsByTagName("user");  
            for(int i=0; i<nodeList.getLength(); i++){  
                String id = document.getElementsByTagName("id").item(i).getFirstChild().getNodeValue();  
                //删除节点时传入的参数  
                if(id.equals(deleteNumber)){  
                    Node node = nodeList.item(i);  
                    node.getParentNode().removeChild(node);  
                    saveXML(document, filePath); 
                    break;
                }  
            }  
            
            //或者把delflag 删除标志改为1
            
            return true;  
        }catch(Exception e){  
            e.printStackTrace();  
            System.out.println(e.getMessage());  
            return false;  
        }  
    }  
      
    /** 
     * 修改制定的xml 
     * @param filePath 
     * @return 
     */  
    public static boolean updateXML(String filePath,String updateNumber,String userName,String userCode,String userGender,String userMobile,String userAddress,String userRemark){  
         //读取传入的路径，返回一个document对象  
         Document document = loadInit(filePath);  
         try{  
            //获取叶节点  
             NodeList nodeList = document.getElementsByTagName("user");  
            //遍历叶节点  
             for(int i=0; i<nodeList.getLength(); i++){  
                 String did = document.getElementsByTagName("id").item(i).getFirstChild().getNodeValue();  
                 //修改节点时传入的参数  
                 if(did.equals(updateNumber)){  
                     document.getElementsByTagName("name").item(i).getFirstChild().setNodeValue(userName); 
                     document.getElementsByTagName("mobile").item(i).getFirstChild().setNodeValue(userMobile);  
                     document.getElementsByTagName("gender").item(i).getFirstChild().setNodeValue(userGender);  
                     
//                     Node ncode = document.getElementsByTagName("code").item(i).getFirstChild();
//                     if(ncode==null){
//                    	 Element eltCode = document.createElement("code");
//                         eltCode.appendChild(document.createTextNode(userCode));
//                     }else{
//                    	 ncode.setNodeValue(userCode);  
//                     }
                     document.getElementsByTagName("code").item(i).setTextContent(userCode); 
                     
                     document.getElementsByTagName("address").item(i).setTextContent(userAddress);  
                     document.getElementsByTagName("remark").item(i).setTextContent(userRemark); 
                     break;
                 }  
             }  
             saveXML(document, filePath);  
             return true;  
         }catch(Exception e){  
             e.printStackTrace();  
             System.out.println(e.getMessage());  
             return false;  
         }  
    }  
      
    /** 
     * 添加节点 
     * @param filePath 
     * @return 
     */  
    public static boolean addXML(String filePath,String userName,String userCode,String userGender,String userMobile,String userAddress,String userRemark){  
        try{  
            //读取传入的路径，返回一个document对象  
            Document document = loadInit(filePath);  
            //创建叶节点  
            Element eltUser = document.createElement("user");  
            
            Element eltId = document.createElement("id");//创建叶节点的第一个元素  
            
            //遍历已有user，取最大的id+1作为新的id
            Long reid = 0l;
            //获取叶节点  
            NodeList nodeList = document.getElementsByTagName("user");  
            //遍历叶节点  
            for(int i=0; i<nodeList.getLength(); i++){  
                Long id = Long.valueOf(document.getElementsByTagName("id").item(i).getFirstChild().getNodeValue());  
                if(id>reid)reid=id;
            }  
            reid+=1;
            eltId.appendChild(document.createTextNode(reid.toString()));//把该文本节点加入到叶节点的第一个元素里面  
            
            Element eltDelflag = document.createElement("delflag");//创建叶节点的第二个元素  
            eltDelflag.appendChild(document.createTextNode("0"));//把该文本节点加入到叶节点的第二个元素里面  
            
            Element eltGender = document.createElement("gender");//创建叶节点的第三个元素  
            eltGender.appendChild(document.createTextNode(userGender));//把该文本节点加入到叶节点的第三个元素里面  
            
            Element eltName = document.createElement("name");//创建叶节点的第四个元素  
            eltName.appendChild(document.createTextNode(userName));//把该文本节点加入到叶节点的第四个元素里面  
            
            Element eltCode = document.createElement("code");//创建叶节点的第五个元素  
            eltCode.appendChild(document.createTextNode(userCode));//把该文本节点加入到叶节点的第五个元素里面  
            
            Element eltMobile = document.createElement("mobile");//创建叶节点的第六个元素  
            eltMobile.appendChild(document.createTextNode(userMobile));//把该文本节点加入到叶节点的第六个元素里面  
            
            Element eltAddress = document.createElement("address");//创建叶节点的第七个元素  
            eltAddress.appendChild(document.createTextNode(userAddress));//把该文本节点加入到叶节点的第七个元素里面  
            
            Element eltRemark = document.createElement("remark");//创建叶节点的第八个元素  
            eltRemark.appendChild(document.createTextNode(userRemark));//把该文本节点加入到叶节点的第八个元素里面  
            
            
            //把叶节点下的元素加入到叶节点下  
            eltUser.appendChild(eltId);  
            eltUser.appendChild(eltDelflag);  
            eltUser.appendChild(eltGender);  
            eltUser.appendChild(eltName);  
            eltUser.appendChild(eltCode);  
            eltUser.appendChild(eltMobile);  
            eltUser.appendChild(eltAddress);  
            eltUser.appendChild(eltRemark);  
            //获取根节点  
            Element eltRoot = document.getDocumentElement();  
            //把叶节点加入到根节点下  
            eltRoot.appendChild(eltUser);  
            //更新修改后的源文件  
            saveXML(document, filePath);  
            return true;  
        }catch(Exception e){  
            e.printStackTrace();  
            System.out.println(e.getMessage());  
            return false;  
        }  
    }  
      
    /** 
     * 把修改后的document写进源文件（更新源文件） 
     * @param document 
     * @param filePath 
     * @return 
     */  
    public static boolean saveXML(Document document, String filePath){  
        try{  
            TransformerFactory tFactory = TransformerFactory.newInstance();  
            Transformer transformer = tFactory.newTransformer();  
              
            DOMSource source = new DOMSource(document);  
            StreamResult result = new StreamResult(new File(filePath));  
            transformer.transform(source, result);  
            return true;  
        }catch(Exception e){  
            e.printStackTrace();  
            System.out.println(e.getMessage());  
            return false;  
        }  
    }  
      
    /** 
     * 获取xml文件的所有记录 
     * @param filePath 
     * @return 
     */  
    public static List<Map> selectXML(String filePath){  
         List<Map> userList = new ArrayList<Map>();  
         try{  
             //读取传入的路径，返回一个document对象  
             Document document = loadInit(filePath);  
             //获取叶节点  
             NodeList nodeList = document.getElementsByTagName("user");  
             //遍历叶节点  
             for(int i=0; i<nodeList.getLength(); i++){  
                 Long id = Long.valueOf(document.getElementsByTagName("id").item(i).getFirstChild().getNodeValue());  
                 Integer delflag = Integer.parseInt(document.getElementsByTagName("delflag").item(i).getFirstChild().getNodeValue());  
                 Integer gender = Integer.parseInt(document.getElementsByTagName("gender").item(i).getFirstChild().getNodeValue());  
                 String name = document.getElementsByTagName("name").item(i).getFirstChild().getNodeValue();  
                 
                 Node ncode = document.getElementsByTagName("code").item(i).getFirstChild();
                 String code = ncode==null?"":ncode.getNodeValue();
                 Node nmobile = document.getElementsByTagName("mobile").item(i).getFirstChild();
                 String mobile = nmobile==null?"":nmobile.getNodeValue();  
                 Node naddress = document.getElementsByTagName("address").item(i).getFirstChild();
                 String address = naddress==null?"":naddress.getNodeValue();  
                 Node nremark = document.getElementsByTagName("remark").item(i).getFirstChild();
                 String remark = nremark==null?"":nremark.getNodeValue();  
                 Map userMap = new HashMap();
                 userMap.put("delflag", delflag);
                 userMap.put("id", id);
                 userMap.put("gender", gender);
                 userMap.put("name", name);
                 userMap.put("code", code);
                 userMap.put("mobile", mobile);
                 userMap.put("address", address);
                 userMap.put("remark", remark);
                 
                 
                 userList.add(userMap);
             }  
             return userList;  
         }catch(Exception e){  
             e.printStackTrace();  
             System.out.println(e.getMessage());  
             return null;  
         }  
    }  
    
    
    
    public static URL getResource(Class callingClass, String resourceName) {
    	URL url = Thread.currentThread().getContextClassLoader().getResource(resourceName);

    	if (url == null) {
    	url = DemoApplication.class.getClassLoader().getResource(resourceName);
    	}

    	if (url == null) {
    	ClassLoader cl = callingClass.getClassLoader();

    	if (cl != null) {
    	url = cl.getResource(resourceName);
    	}
    	}

    	if ((url == null) && (resourceName != null)
    	&& ((resourceName.length() == 0) || (resourceName.charAt(0) != '/'))) {
    	return getResource(callingClass, '/' + resourceName);
    	}

    	return url;
    	}
}  
	  
	  
	  
	  
	
