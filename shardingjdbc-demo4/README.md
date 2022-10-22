# 熟悉ShardingJDBC

## 绑定表


### 什么是绑定表

- 指分片规则一致的主表和子表
- 比如product_order表和product_order_item表，均按照order_id分片，则此两张表互为绑定表关系
- 绑定表之间的多表关联查询不会出现笛卡尔积关联，关联查询效率将大大提升

<br>

### 默认分库策略

```
spring.shardingsphere.sharding.default-database-strategy.inline.sharding-column = user_id
spring.shardingsphere.sharding.default-database-strategy.inline.algorithm-expression = ds$->{user_id % 2}
```

<br>

### 绑定表配置

```
spring.shardingsphere.sharding.binding‐tables[0] = product_order,product_order_item
```

<br>


## 注意

- 了解绑定表和未绑定表的区别可以通过调试的方式进行了解