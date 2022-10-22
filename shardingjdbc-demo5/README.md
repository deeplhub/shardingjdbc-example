# 熟悉ShardingJDBC

广播表+分库分表+绑定表

## 默认分库策略

```
spring.shardingsphere.sharding.default-database-strategy.inline.sharding-column = user_id
spring.shardingsphere.sharding.default-database-strategy.inline.algorithm-expression = ds$->{user_id % 2}
```

<br>

## 绑定表

```
spring.shardingsphere.sharding.binding‐tables[0] = product_order,product_order_item
```