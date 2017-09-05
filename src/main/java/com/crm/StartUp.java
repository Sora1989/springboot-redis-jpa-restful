package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.util.TypeUtils;
import com.crm.cfgdata.base.cache.CfgWsClientCacheService;
import com.crm.cfgdata.base.cache.StaticDataCacheService;

/**
 * 服务启动执行，加载配置问题
 */
@Component
public class StartUp implements CommandLineRunner {
	
	@Autowired
	private StaticDataCacheService staticDataCacheService ;
	@Autowired
	private CfgWsClientCacheService cfgWsClientCacheService ;

	
    @Override
    public void run(String... args) throws Exception {
        System.out.println("IndexStartupRunner >>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 <<<<<<<<<<<<<");
        //加载字典项      
        staticDataCacheService.refreshAll();
        System.out.println("IndexStartupRunner >>>>>>>>>>>>>>>static data字典项加载结束 <<<<<<<<<<<<<");
        //加载cfgWsClient数据参数
        cfgWsClientCacheService.refreshAll();
        System.out.println("IndexStartupRunner >>>>>>>>>>>>>>>cfgWsClient加载结束 <<<<<<<<<<<<<");
        
        //参数设置
        TypeUtils.compatibleWithJavaBean = true;
        
    }
    

}
