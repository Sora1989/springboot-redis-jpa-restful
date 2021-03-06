package com.crm.esb.invoke;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.cfgdata.base.cache.CfgWsClientCacheService;
import com.crm.cfgdata.base.domain.CfgWsClient;
import com.crm.cfgdata.base.repository.CfgWsClientRepository;
import com.crm.comm.exception.ServiceException;
import com.crm.esb.invoke.pojo.RespParam;

//import com.ai.appframe2.common.SessionManager;
//import com.ai.appframe2.privilege.UserInfoInterface;
//import com.asiainfo.aiccsp2.common.util.CastTimeUtil;
//import com.asiainfo.aiccsp2.common.util.ServiceLogDeal;


@Service
public class SoapUtil { 
/**
* 
* @Function: invokeMethod
* @Description: WebClient客户端链接WebService服务器的工具方法
*
* @param: serviceName
* @param: busiInfo    BUSI_INFO对象
* @return java.lang.String
* @throws：抛出Exception
*
* @version: v1.0.0
* @author: zhouqishan
* 
*/
	private static final Log log = LogFactory.getLog(SoapUtil.class);

	public static String invokeMethod(String serviceName,Object busiInfo) throws Exception {
	
				
		//查询数据库
		//cfgWsClientRepository.findByCfgWsClientCode();

		//CfgWsClient cfgWsClient = new CfgWsClient();
		//cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
		
				
		WsClient client = new WsClient(serviceName);
		
		String returnValue="";
		String reqXml = null;
		
		//TODO LOG相关，时间戳
		//Timestamp startTime = ServiceManager.getIdGenerator().getSysDate();
		//long beginTime = System.currentTimeMillis();
		try {
			reqXml = XStreamUtil.getEsbReqXml(busiInfo);
			returnValue = (String)client.invoke(new Object[] {reqXml});
		} catch (Exception e) {
			returnValue=e.getMessage();
			throw new Exception(e);
		}finally{
			try {
				//TODO
				//记录调用日志
             }catch (Exception e2) {
            	//TODO
 				//记录错误日志
             }
		}
		return returnValue;
	}

public static String invokeMethod(CfgWsClient cfgWsClient,Object busiInfo) throws Exception {
	
	//查询数据库
	//cfgWsClientRepository.findByCfgWsClientCode();

	//CfgWsClient cfgWsClient = new CfgWsClient();
	//cfgWsClient =cfgWsClientCacheService.getObj(serviceName);
	
			
	WsClient client = new WsClient(cfgWsClient);
	
	String returnValue="";
	String reqXml = null;
	
	//TODO LOG相关，时间戳
	//Timestamp startTime = ServiceManager.getIdGenerator().getSysDate();
	//long beginTime = System.currentTimeMillis();
	try {
		reqXml = XStreamUtil.getEsbReqXml(busiInfo);
		log.info("send to ESB starts here:" + reqXml);
		returnValue = (String)client.invoke(new Object[] {reqXml});
		log.info("receive from ESB starts here:" + returnValue);
	} catch (Exception e) {
		returnValue=e.getMessage();
		throw new Exception(e);
	}finally{
		try {
			//TODO
			//记录调用日志
         }catch (Exception e2) {
        	//TODO
				//记录错误日志
         }
	}
	return returnValue;
}
	
	public static RespParam invokeMethodForResp(String serviceName,Object busiInfo) throws Exception {
		String returnValue = invokeMethod(serviceName,busiInfo);
		IEsbXmlHelper<RespParam> xmlHelper = new EsbXmlHelper();
	    RespParam respParam = xmlHelper.parseXml(returnValue, RespParam.class);
	    return respParam;
	}
	
	public static RespParam invokeMethodForResp(CfgWsClient cfgWsClient,Object busiInfo) throws Exception {
		String returnValue = invokeMethod(cfgWsClient,busiInfo);
		IEsbXmlHelper<RespParam> xmlHelper = new EsbXmlHelper();
	    RespParam respParam = xmlHelper.parseXml(returnValue, RespParam.class);
	    return respParam;
	}
	


}
