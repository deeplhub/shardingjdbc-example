CREATE TABLE `product_order` (
     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
     `trade_no` VARCHAR(64) NULL DEFAULT NULL COMMENT '订单唯一标识' COLLATE 'utf8mb4_bin',
     `state` VARCHAR(11) NULL DEFAULT NULL COMMENT 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单' COLLATE 'utf8mb4_bin',
     `create_at` DATETIME NULL DEFAULT NULL COMMENT '订单生成时间',
     `pay_amount` DECIMAL(16,2) NULL DEFAULT NULL COMMENT '订单实际支付价格',
     `user_id` BIGINT(20) NULL DEFAULT NULL COMMENT '用户id',
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `trade_no` (`trade_no`) USING BTREE
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
;

CREATE TABLE `product_order_0` (
     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
     `trade_no` VARCHAR(64) NULL DEFAULT NULL COMMENT '订单唯一标识' COLLATE 'utf8mb4_bin',
     `state` VARCHAR(11) NULL DEFAULT NULL COMMENT 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单' COLLATE 'utf8mb4_bin',
     `create_at` DATETIME NULL DEFAULT NULL COMMENT '订单生成时间',
     `pay_amount` DECIMAL(16,2) NULL DEFAULT NULL COMMENT '订单实际支付价格',
     `user_id` BIGINT(20) NULL DEFAULT NULL COMMENT '用户id',
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `trade_no` (`trade_no`) USING BTREE
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
;

CREATE TABLE `product_order_1` (
     `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
     `trade_no` VARCHAR(64) NULL DEFAULT NULL COMMENT '订单唯一标识' COLLATE 'utf8mb4_bin',
     `state` VARCHAR(11) NULL DEFAULT NULL COMMENT 'NEW 未支付订单,PAY已经支付订单,CANCEL超时取消订单' COLLATE 'utf8mb4_bin',
     `create_at` DATETIME NULL DEFAULT NULL COMMENT '订单生成时间',
     `pay_amount` DECIMAL(16,2) NULL DEFAULT NULL COMMENT '订单实际支付价格',
     `user_id` BIGINT(20) NULL DEFAULT NULL COMMENT '用户id',
     PRIMARY KEY (`id`) USING BTREE,
     UNIQUE INDEX `trade_no` (`trade_no`) USING BTREE
)
COLLATE='utf8mb4_bin'
ENGINE=InnoDB
;
