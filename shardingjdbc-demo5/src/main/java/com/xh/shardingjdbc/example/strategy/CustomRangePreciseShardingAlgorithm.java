package com.xh.shardingjdbc.example.strategy;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 范围精确分片算法
 *
 * @author H.Yang
 * @date 2022/10/22
 */
public class CustomRangePreciseShardingAlgorithm implements RangeShardingAlgorithm<Long> {

    /**
     * @param dataSourceNames    数据源集合
     *                           在分库时值为所有分片库的集合 databaseNames
     *                           分表时为对应分片库中所有分片表的集合 tablesNames
     * @param rangeShardingValue 分片属性，包括
     *                           logicTableName 为逻辑表，
     *                           columnName 分片健（字段），
     *                           value 为从 SQL 中解析出的分片健的值
     * @return
     */
    @Override
    public Collection<String> doSharding(Collection<String> dataSourceNames, RangeShardingValue<Long> rangeShardingValue) {
        Set<String> result = new LinkedHashSet<>();
        // between 起始值
        Long lower = rangeShardingValue.getValueRange().lowerEndpoint();
        // between 结束值
        Long upper = rangeShardingValue.getValueRange().upperEndpoint();

        // 循环范围计算分库逻辑
        for (long i = lower; i <= upper; i++) {
            for (String databaseName : dataSourceNames) {
                if (databaseName.endsWith(i % dataSourceNames.size() + "")) {
                    result.add(databaseName);
                }
            }
        }
        return result;
    }
}
