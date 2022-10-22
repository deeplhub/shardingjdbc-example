# 熟悉ShardingJDBC

## 分片策略

### 分片键 (PartitionKey)

- 用于分片的数据库字段，是将数据库(表)水平拆分的关键字段
- 比如prouduct_order订单表，根据订单号 out_trade_no做哈希取模，则out_trade_no是分片键
- 除了对单分片字段的支持，ShardingSphere也支持根据多个字段进行分片

<br>

### 1. 行表达式分片策略(重要)

**InlineShardingStrategy**

- 只支持【单分片键】使用Groovy的表达式，提供对SQL语句中的 =和IN 的分片操作支持
- 可以通过简单的配置使用，无需自定义分片算法，从而避免繁琐的Java代码开发

```
# 表示订单表根据user_id模8，而分成8张表，表名称为`prouduct_order_0`到`prouduct_order_7
prouduct_order_$->{user_id % 8}` 
```


<br>


### 2. 标准分片策略

- 只支持【单分片键】，提供PreciseShardingAlgorithm和RangeShardingAlgorithm两个分片算法
- PreciseShardingAlgorithm 精准分片 是必选的，用于处理=和IN的分片
- RangeShardingAlgorithm 范围分配 是可选的，用于处理BETWEEN AND分片
- 如果不配置RangeShardingAlgorithm，如果SQL中用了BETWEEN AND语法，则将按照全库路由处理，性能下降


#### 精准分片策略 - StandardShardingStrategy

- 只支持【单分片键】，提供PreciseShardingAlgorithm和RangeShardingAlgorithm两个分片算法
- PreciseShardingAlgorithm 精准分片 是必选的，用于处理=和IN的分片
- RangeShardingAlgorithm 范围分片 是可选的，用于处理BETWEEN AND分片
- 如果不配置RangeShardingAlgorithm，如果SQL中用了BETWEEN AND语法，则将按照全库路由处理，性能下降

<br>

**指定精准分片策略(水平分库)**

```
spring.shardingsphere.sharding.tables.product_order.database-strategy.standard.sharding-column=user_id
spring.shardingsphere.sharding.tables.product_order.database-strategy.standard.precise-algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomDatabasePreciseShardingAlgorithm
```


**指定精准分片策略(水平分表)**

```
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.sharding-column=id
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.precise-algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomTablePreciseShardingAlgorithm
```

<br><br>

#### 范围分片策略 - RangeShardingAlgorithm

- 用于处理BETWEEN AND语法，没配置的话会报错 Cannot find range sharding strategy in sharding rule.
- 主要是会根据 SQL中给出的分片健值范围值处理分库、分表逻辑


**范围分片**

```
spring.shardingsphere.sharding.tables.product_order.table-strategy.standard.range-algorithm-class-name=com.xh.shardingjdbc.example.strategy.CustomRangePreciseShardingAlgorithm
```


<br>



### 3. 复合分片策略(用的不多，了解就好)

- 支持【多分片键】，多分片键之间的关系复杂，由开发者自己实现，提供最大的灵活度
- 提供对SQL语句中的=, IN和BETWEEN AND的分片操作支持

#### 复合分片算法 - ComplexShardingStrategy

- 提供对SQL语句中的=, IN和BETWEEN AND的分片操作，支持【多分片键】
- 由于多分片键之间的关系复杂，Sharding-JDBC并未做过多的封装
- 而是直接将分片键值组合以及分片操作符交于算法接口，全部由应用开发者实现，提供最大的灵活度


<br>


### 4. Hint分片策略

- 这种分片策略无需配置分片健，分片健值也不再从 SQL中解析，外部手动指定分片健或分片库，让 SQL在指定的分库、分表中执行
- 用于处理使用Hint行分片的场景，通过Hint而非SQL解析的方式分片的策略
- Hint策略会绕过SQL解析的，对于这些比较复杂的需要分片的查询，Hint分片策略性能可能会更好
- 可以指定sql去某个库某个表进行执行


#### Hint分片策略 - HintShardingStrategy

hint的中文意思：提示、暗示



<br>



### 5. 不分片策略 NoneShardingStrategy

- 不分片的策略。