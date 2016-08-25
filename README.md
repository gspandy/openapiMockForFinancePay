## 依赖openapi-arch实现的对openapi的Mock

> 使用方法：

    1. 在com.yiji.openapimock.service下定义子包
    2. 参考openapi文档，编写Request,Response
    3. 参考openapi文档，编写ApiService
    4. 在ApiService#doService方法中编写mock逻辑，并返回结果或抛出异常
    5. 如果是异步，直接在测试代码中使用NotifyUtils进行通知
    参考TestApiService,TestRequest,TestResponse

> 请求地址：http://{ip}:{port}/gateway.html

    配置在需要测试的应用中

> Mock通知地址：http://{ip}:{port}/mocknotify.html

    Mock通知参数：
        gid 原始请求生成的GID
        partnerId 商户ID
        merchOrderNo 商户订单号
        data(Map<String,String>的JSON格式) 通知参数

    参考工具类  public static Result notify(String gid, String partnerId, String merchOrderNo, Notify notify);

> 建表语句

    CREATE TABLE `order_info` (
      `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
      `gid` varchar(40) NOT NULL COMMENT '全站式统一流水号',
      `order_no` varchar(40) NOT NULL COMMENT '订单号',
      `partner_id` varchar(40) NOT NULL COMMENT '合作伙伴id',
      `service` varchar(32) NOT NULL,
      `version` varchar(8) NOT NULL,
      `charset` varchar(16) DEFAULT NULL COMMENT '请求编码',
      `trade_no` varchar(40) DEFAULT NULL COMMENT '交易流水号',
      `notify_url` varchar(256) DEFAULT NULL COMMENT '异步通知地址',
      `return_url` varchar(256) DEFAULT NULL COMMENT '同步返回地址',
      `business_info` varchar(1024) DEFAULT NULL COMMENT '请求业务信息',
      `raw_add_time` datetime DEFAULT NULL COMMENT '创建/更新时间',
      `raw_update_time` datetime DEFAULT NULL,
      `sign_type` varchar(40) DEFAULT NULL,
      `merch_order_no` varchar(64) DEFAULT NULL COMMENT '商户订单号',
      `oid` varchar(48) DEFAULT NULL COMMENT '内部订单号',
      `context` varchar(128) DEFAULT NULL COMMENT '客户端会话',
      PRIMARY KEY (`id`),
      UNIQUE KEY `UK_PARTNER_ORDER` (`partner_id`,`order_no`),
      UNIQUE KEY `gid_idx` (`gid`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='请求信息表';


