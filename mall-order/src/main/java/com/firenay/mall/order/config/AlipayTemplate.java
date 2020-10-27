package com.firenay.mall.order.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.firenay.mall.order.vo.PayVo;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "alipay")
@Component
@Data
public class AlipayTemplate {

    //在支付宝创建的应用的id
    private   String app_id = "2016102700769781";

    // 商户私钥，您的PKCS8格式RSA2私钥
    private  String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC/Es3usMibIWvfYU88rZdT3ladCwY0FmCnljCjIK69+rNtH0tC5wDcbca72tY5A8YV8Xt7QNymY6ZQZ3Bif+uCAJbIbK1BRc2gbmIDjYvU/R7VcxRCYbEFbqnH2BPi9EwgNdt/rw5HIk5vte5W7GoqPDyIpyi0Wy+NIdFFr6MdiTPwXv8ue6HhcRMwTC4AsW0gTAm3b85gaac13h4wEZDnHXYWSmtg2sSqldrQ/almFe4ibyqFRg+1kylIwVo3n9HFa0IoWE541dryHT9QG7G3WoQMnkCWVT/drkQ51GdG8PthwdgW6mM3ScJoC+5+iiEYs+g6DGqt4Ta/QQ4GFHKbAgMBAAECggEAGTjXPDnT0T6BKdSDjCPyBN0lm8dXw0ps6dJWi0IGLwfH5ZCq86LgpzhKcoO5oX8RB9Z/kU6HkeM3kgeFe0sdgGSpgr1txV78fL/1ajimC7B6AH0XYIfawTfRa5LnVR8gaWQSnHE0NkmeBvsCAjFk9jxLVVKTefNLfJrJMCS2KHC4dL7VSEAq51+x/HzKhrR62by2hYaSEMspRJCfHeYvK6RW/XvmvOY5+sPbP2LUOqTVhcjs4OJe9xAEFNKJ+Y14g4YH2I4UIFRAklh55Xrr0hg6tocMyFHSe6YUAQbv7nWcbY2XK6v+JlQn6roeAWIxUA7f/Ar03u/9rllmOOXlKQKBgQDwlEGX/ZxlzQzvWNErFSts6PV5c6AaRqBrm99q/qUjKC+rmduGBQ101y3/Ti63A5Ur8EdB6+oTskDIUe4pwtPntX3xlVZv1YHHyCXu5gOyUf+qwrR7TqNNqI/eaeCvlBp+KSZMzmKerBWJ2WvGNs5Unj6YO7E5I5xBbYpkOvqPHwKBgQDLUjFoC+2NeJn1BZdjwoJBfVYF8e18MNTcUtRdAYFZIBf//lhXHbCFvhq1+y+qKpoVmOpeBovWzZVXUmxc/UqBuJ1YqkTQ7MOy2qDtlB6lnQujBja66XTYNjoEbA0jZszQ32q5vCQqoGH+DqtDIofYIVJc9RDrln60FqVGnzZ5BQKBgB3WRUxUZ9E4XSJSIZ72QSyAt/EYJgMcP0kZS9w5OMHjegYOTuuQNNsI1OuVBrYr+5Q3eJ70Y1OOB/rQLnl/cEiMedI8czvrfu0IJaw7WroC8XJ8M2YXmqlG/pDXEMa115NOBzH/ZrvHG+S80mEC6xQTjC/VN2WexQJYU5GavviBAoGBALH6SPVjO5bTMzGgq1zQL2VUabDajaBgvnP+rZaccrWpuliENKBNhPAN8SPLtXWnxSmSqdWUtWRaoZfGtsTPlCDpkhLDOWoJV2WAq85MEme2iTEzh0UmhvmcvjyQuQ98NV3BtJLRdnc53Y2fGZuy5mbzBD4K57zSCCdsi1C+ndhhAoGAfg0OE3hJqUZwjhGrj3BXIWg2zzrGqfMZeMwHB+nX0ntSx9IXu679HjBGPPUf/mgOo3cwvdbF4nbjrtR4tGd7gBZXmkkA3sCJ6T9XOpGHAQ6LNTT4eEmnXKTN3/hRkwcbRakYudLByivHH13+XbFlo641tyuPzcFDxmP07/ZvyKE=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    private  String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgZ41zXxJIpYnPm1DeebdVJd/4M/aVxTWPPToFB04IRMSK26jOHhwxJ8VYz4rKppu8tEGOXDhx2tcx03Kdr4F3w5x5V3yJKD6hVF8+XMCNamzwhGEtx5W2okcbet43WYQfU8q00Q+QmuZtIi3+0QjcSSQ6Dp+u6wovnUj018MRl9rqgWG/x0/nJE8FzpWNWrD1IxSgvr7AFyZfcLhaorrwkq7bKZ8MnWqV3IIaeUv0WpWgTBXmEkzEvFZIiqTTBzuB1k+Z1hUuXQVcd4AaYrJqgjyLjsBBOAYFUzRrEA4yOaoO4dTKkVfsQ5vKRQs+HUniKHmBALyqMEJbNY+/LXbtQIDAQAB";
    // 服务器[异步通知]页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 支付宝会悄悄的给我们发送一个请求，告诉我们支付成功的信息
    private  String notify_url = "http://member.glmall.com/memberOrder.html";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步通知，支付成功，一般跳转到成功页
    private  String return_url = "http://member.glmall.com/memberOrder.html";

    // 签名方式
    private  String sign_type = "RSA2";

    // 字符编码格式
    private  String charset = "utf-8";

    // 自动关单时间
    private String timeout = "15m";

    // 支付宝网关； https://openapi.alipaydev.com/gateway.do
    private  String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public  String pay(PayVo vo) throws AlipayApiException {

        //AlipayClient alipayClient = new DefaultAlipayClient(AlipayTemplate.gatewayUrl, AlipayTemplate.app_id, AlipayTemplate.merchant_private_key, "json", AlipayTemplate.charset, AlipayTemplate.alipay_public_key, AlipayTemplate.sign_type);
        //1、根据支付宝的配置生成一个支付客户端
        AlipayClient alipayClient = new DefaultAlipayClient(gatewayUrl,
                app_id, merchant_private_key, "json",
                charset, alipay_public_key, sign_type);

        //2、创建一个支付请求 //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = vo.getOut_trade_no();
        //付款金额，必填
        String total_amount = vo.getTotal_amount();
        //订单名称，必填
        String subject = vo.getSubject();
        //商品描述，可空
        String body = vo.getBody();

        // 30分钟内不付款就会自动关单
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"timeout_express\":\"" + timeout + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        //会收到支付宝的响应，响应的是一个页面，只要浏览器显示这个页面，就会自动来到支付宝的收银台页面
        return result;
    }
}
