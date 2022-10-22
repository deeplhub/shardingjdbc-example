# 熟悉ShardingJDBC

精准分片算法

<br>

# 指定精准分片算法(水平分库)

```
spring.shardingsphere.sharding.tables.product_order.database-strategy.standard.sharding-column=user_id
spring.shardingsphere.sharding.tables.product_order.database-strategy.standard.precise-algorithm-class-name=com.xh.shardingjdbc.example.strategy.DatabasePreciseShardingAlgorithm
```

<br>

# 指定精准分片算法(水平分表)

```
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.sharding-column=id
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.precise-algorithm-class-name=com.xh.shardingjdbc.example.strategy.TablePreciseShardingAlgorithm
```
