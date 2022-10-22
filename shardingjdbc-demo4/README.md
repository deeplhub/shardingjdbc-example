# 熟悉ShardingJDBC

广播表+分库分表

## 什么是广播表

- 指所有的分片数据源中都存在的表，表结构和表中的数据在每个数据库中均完全一致
- 适用于数据量不大且需要与海量数据的表进行关联查询的场景
- 例如：字典表、配置表

多个数据库中存在相同的表，需要保持数据一致的情况下用到。


<br>

## 配置广播表

```
spring.shardingsphere.sharding.broadcast-tables=sys_config
spring.shardingsphere.sharding.tables.sys_config.key-generator.column=id
spring.shardingsphere.sharding.tables.sys_config.key-generator.type=SNOWFLAKE
spring.shardingsphere.sharding.tables.sys_config.key-generator.props.worker.id=1
```


<br>


## 配置分库规则

```
spring.shardingsphere.sharding.tables.product_order.database-strategy.inline.sharding-column=user_id
spring.shardingsphere.sharding.tables.product_order.database-strategy.inline.algorithm-expression=ds$->{user_id % 2}
```

<br>

## 配置分表策略

```
## 指定product_order表的数据分布情况，配置数据节点,行表达式标识符使用 ${...} 或 $->{...}，但前者与 Spring 本身的文件占位符冲突，所以在 Spring 环境中建议使用 $->{...}
spring.shardingsphere.sharding.tables.product_order.actual-data-nodes=ds$->{0..1}.product_order_$->{0..1}

## 分片列名称；指定product_order表的分片策略，分片策略包括【分片键和分片算法】

spring.shardingsphere.sharding.tables.product_order.table-strategy.inline.sharding-column=id
spring.shardingsphere.sharding.tables.product_order.table-strategy.inline.algorithm-expression=product_order_$->{id % 2}
```
<br>

## 注意：

如果分库和分表使用的是相同的字段会造成部份表有数据，部份表没有数据

### 示例：

如果分库使用user_id，那么分表时就不要用user_id,如果用user_id会造成部份表有数据，部份表没有数据

```
spring.shardingsphere.sharding.tables.product_order.table-strategy.inline.sharding-column=user_id
spring.shardingsphere.sharding.tables.product_order.table-strategy.inline.algorithm-expression=product_order_$->{user_id % 2}
```


<br>

<br><br>


# 注意点：

分库分表中间件，对应的数据库字段，不能是sql的关键字，否则容易出问题，且报错不明显