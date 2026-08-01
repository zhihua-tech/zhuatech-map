# Map 架构

版权所有 © 2026 上海如静知华信息科技有限公司。

浏览器通过 Vue 管理端或营销运营专员端访问 Spring Boot REST API。安全层完成 JWT 与角色鉴权，业务层负责营销活动、商品、受众中心、核验和结果记录，JPA/Flyway 管理 MySQL 数据。

管理端角色为 `DOMAIN_OPERATOR`、`QUALITY`、`ADMIN`；执行端角色为 `DOMAIN_USER`。正式部署建议将受众中心连接置于独立采集服务，并隔离业务单元网络和办公网络。
