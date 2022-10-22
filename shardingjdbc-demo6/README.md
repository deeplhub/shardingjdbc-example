# 熟悉ShardingJDBC

## 多种分片策略实战

### 复合分片算法(用的不多，了解就好)

**ComplexShardingStrategy**

- 提供对SQL语句中的=, IN和BETWEEN AND的分片操作，支持【多分片键】
- 由于多分片键之间的关系复杂，Sharding-JDBC并未做过多的封装
- 而是直接将分片键值组合以及分片操作符交于算法接口，全部由应用开发者实现，提供最大的灵活度


