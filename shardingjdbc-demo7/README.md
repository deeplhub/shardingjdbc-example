# 熟悉ShardingJDBC

## 分片策略

### 4. Hint分片策略

**HintShardingStrategy**

hint的中文意思：提示、暗示

- 这种分片策略无需配置文件进行配置分片健，分片健值也不再从 SQL中解析，外部手动指定分片健或分片库，让 SQL在指定的分库、分表中执行
- 通过Hint代码指定的方式而非SQL解析的方式分片的策略
- Hint策略会绕过SQL解析的，对于这些比较复杂的需要分片的查询，Hint分片策略性能可能会更好
- 可以指定sql去某个库某个表进行执行


### Hint分片策略

```
spring.shardingsphere.sharding.tables.product_order.database-strategy.hint.algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomDBHintShardingAlgorithm
spring.shardingsphere.sharding.tables.product_order.table-strategy.hint.algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomTableHintShardingAlgorithm
```

<br>


> 自定义完算法只实现了一部分，需要在调用 SQL 前通过 HintManager 指定分库、分表信息