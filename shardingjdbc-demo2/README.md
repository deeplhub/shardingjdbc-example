# 熟悉ShardingJDBC

雪花算法生成ID

```
spring.shardingsphere.sharding.tables.product_order.key-generator.type=SNOWFLAKE
spring.shardingsphere.sharding.tables.product_order.key-generator.column=id
spring.shardingsphere.sharding.tables.product_order.key-generator.props.worker.id=1
```