#配置中心测试

##返回文件及相关信息
<http://localhost:3003/server-app01/dev>
<http://localhost:3003/server-app01/prod>

##直接访问文件
<http://localhost:3003/server-app01-prod.properties>


#测试访问接口规则 

label > 对应于git地址的分支 不指定默认为master
/{application}/{profile}[/{label}]
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties