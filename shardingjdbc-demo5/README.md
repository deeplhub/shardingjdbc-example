# 熟悉ShardingJDBC

## 多种分片策略实战

### 精准分片算法

**StandardShardingStrategy**

- 只支持【单分片键】，提供PreciseShardingAlgorithm和RangeShardingAlgorithm两个分片算法
- PreciseShardingAlgorithm 精准分片 是必选的，用于处理=和IN的分片
- RangeShardingAlgorithm 范围分片 是可选的，用于处理BETWEEN AND分片
- 如果不配置RangeShardingAlgorithm，如果SQL中用了BETWEEN AND语法，则将按照全库路由处理，性能下降

<br>

#### 指定精准分片算法(水平分库)

```
spring.shardingsphere.sharding.tables.product_order.database-strategy.standard.sharding-column=user_id
spring.shardingsphere.sharding.tables.product_order.database-strategy.standard.precise-algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomDatabasePreciseShardingAlgorithm
```

<br>

#### 指定精准分片算法(水平分表)

```
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.sharding-column=id
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.precise-algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomTablePreciseShardingAlgorithm
```

<br><br>

### 范围分片算法

**RangeShardingAlgorithm**

- 用于处理BETWEEN AND语法，没配置的话会报错 Cannot find range sharding strategy in sharding rule.
- 主要是会根据 SQL中给出的分片健值范围值处理分库、分表逻辑

<br>

#### 范围分片

```
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.range-algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomRangePreciseShardingAlgorithm
```

### 复合分片算法(用的不多，了解就好)

**ComplexShardingStrategy**

- 提供对SQL语句中的=, IN和BETWEEN AND的分片操作，支持【多分片键】
- 由于多分片键之间的关系复杂，Sharding-JDBC并未做过多的封装
- 而是直接将分片键值组合以及分片操作符交于算法接口，全部由应用开发者实现，提供最大的灵活度

<br>

> 复合分片算法示例参考 demo6

<br>

### Hint分片算法
