###Mybatis生成模板
```
1:配置数据源 和 需要的映射 实体类的表名 src/main/mybatisGenerator/generatorDbConfig.properties

2:执行gradle mybatisGenerate

3:wow! en! it is ok.

4:可能遇到的错误
"context" 的内容必须匹配
 "(property*,plugin*,comm?,
 (connectionFactory|jdbcConnection),javaTypeResolver?,
 javaModelGenerator,
 sqlMapGenerator?,
 javaClientGenerator?,
 table+)"。

 配置文件摆放节点要按照这个顺序 不然会报错

```