# 熟悉ShardingJDBC

## 雪花算法生成ID

### 方式一

```
@TableId(value = "id", type = IdType.ASSIGN_ID)
```

<br>

### 方式二

```
spring.shardingsphere.sharding.tables.product_order.key-generator.type=SNOWFLAKE
spring.shardingsphere.sharding.tables.product_order.key-generator.column=id
spring.shardingsphere.sharding.tables.product_order.key-generator.props.worker.id=1
```