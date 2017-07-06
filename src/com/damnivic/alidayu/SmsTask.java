package com.damnivic.alidayu;

import java.util.Collection;
import java.util.Map;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Created on 17/6/29.
 * 短信API产品的DEMO程序,工程中包含了一个SmsDemo类，直接通过
 * 执行main函数即可体验短信产品API功能(只需要将AK替换成开通了云通信-短信产品功能的AK即可)
 * 工程依赖了2个jar包(存放在工程的libs目录下)
 * 1:aliyun-java-sdk-core.jar
 * 2:aliyun-java-sdk-dysmsapi.jar
 *
 * 备注:Demo工程编码采用UTF-8
 */
public class SmsTask {
	//产品名称:云通信短信API产品,开发者无需替换
    static final String product = "Dysmsapi";
    //产品域名,开发者无需替换
    static final String domain = "dysmsapi.aliyuncs.com";

    // TODO 此处需要替换成开发者自己的AK(在阿里云访问控制台寻找)
    static final String accessKeyId = "LTAI3TYdvTCSgurl";
    static final String accessKeySecret = "xPzmDomX42tsauiDO2suSWuPCgKlVu";

    public static SendSmsResponse sendSms(SmsBean bean) throws ClientException {

        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);

        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        String[] numbers=bean.getPhonenumbers();
        StringBuilder phoneNumbers=new StringBuilder("");
        if(numbers!=null)
        for(int i=0;i<numbers.length;i++){
        	if(i!=0)
        		phoneNumbers.append(",");
        	phoneNumbers.append(numbers[i]);
        }
        System.out.println("numbers:"+phoneNumbers.toString());
        request.setPhoneNumbers(phoneNumbers.toString());
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(bean.getSignName());
        System.out.println("SignName:"+bean.getSignName());
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(bean.getTemplateCode());
        System.out.println("TemplateCode:"+bean.getTemplateCode());
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        Map<String,String> map=bean.getTemplateParams();
        String[] coll=new String[]{};
        coll=map.keySet().toArray(coll);
        StringBuilder param = new StringBuilder("{");
        for(int i=0;i<coll.length;i++){
        	String key=coll[i];
        	String value=map.get(key);
        	if(i!=0)
        		param.append(",");
        	param.append(String.format("\"%s\":\"%s\"", key,value));
        }
        param.append("}");
        request.setTemplateParam(param.toString());
        System.out.println("TemplateParam:"+param.toString());
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        request.setOutId("12122");

        //hint 此处可能会抛出异常，注意catch
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + sendSmsResponse.getCode());
        System.out.println("Message=" + sendSmsResponse.getMessage());
        System.out.println("RequestId=" + sendSmsResponse.getRequestId());
        System.out.println("BizId=" + sendSmsResponse.getBizId());
        return sendSmsResponse;
    }

}
