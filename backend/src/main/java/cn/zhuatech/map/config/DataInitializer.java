/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.map.config;

import cn.zhuatech.map.model.*;
import cn.zhuatech.map.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seed(OperatingUnitRepository operatingUnits, WorkRecordRepository orders,
                           ResourceRegisterRepository resources, ReviewRecordRepository reviewRecords,
                           UserRepository users, PasswordEncoder encoder) {
        return args -> {
            if (operatingUnits.count() > 0) return;
            OperatingUnit primaryUnit = operatingUnits.save(new OperatingUnit("MAP-CHEM", "企业业务部", "增长运营中心", 180));
            OperatingUnit secondaryUnit = operatingUnits.save(new OperatingUnit("MAP-MICRO", "客户成功部", "研发中心", 120));
            OperatingUnit tertiaryUnit = operatingUnits.save(new OperatingUnit("MAP-MAT", "区域市场部", "工程中心", 96));

            WorkRecord t1 = orders.save(new WorkRecord("CMP-260801-018", "MFG-WP", "制造行业数字化白皮书", tertiaryUnit, 24, 16, 1, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "GW-Q3"));
            WorkRecord t2 = orders.save(new WorkRecord("CMP-260801-021", "RENEW-26", "老客户续费唤醒旅程", primaryUnit, 18, 8, 0, LocalDate.now().plusDays(1), WorkRecord.Status.RUNNING, "TERM-12"));
            WorkRecord t3 = orders.save(new WorkRecord("CMP-260802-006", "EVENT-EAST", "华东技术沙龙邀约", secondaryUnit, 12, 0, 0, LocalDate.now().plusDays(3), WorkRecord.Status.RELEASED, "SP-2026"));
            WorkRecord t4 = orders.save(new WorkRecord("CMP-260728-015", "TRIAL-SUM", "暑期产品试用转化", primaryUnit, 20, 20, 1, LocalDate.now(), WorkRecord.Status.COMPLETED, "SEA-09"));

            resources.saveAll(List.of(
                new ResourceRegister("CAT-HPLC-03", "企业邮件通道", primaryUnit, ResourceRegister.Status.RUNNING, 88),
                new ResourceRegister("CAT-ICP-02", "企业微信通道", primaryUnit, ResourceRegister.Status.IDLE, 76),
                new ResourceRegister("CAT-UTM-05", "线上活动渠道", tertiaryUnit, ResourceRegister.Status.RUNNING, 91),
                new ResourceRegister("CAT-INC-08", "短信触达通道", secondaryUnit, ResourceRegister.Status.ALARM, 62)
            ));
            reviewRecords.saveAll(List.of(
                new ReviewRecord("ISS-260801-032", t1, "内容合规审核", 6, 0, ReviewRecord.Result.PASSED, "黎安"),
                new ReviewRecord("ISS-260801-011", t2, "受众授权复核", 3, 0, ReviewRecord.Result.PASSED, "许澄"),
                new ReviewRecord("ISS-260801-018", t4, "转化归因复核", 5, 1, ReviewRecord.Result.FAILED, "黎安"),
                new ReviewRecord("ISS-260802-003", t3, "营销旅程确认", 4, 0, ReviewRecord.Result.PENDING, "许澄")
            ));
            String demo = encoder.encode("Demo@2026");
            users.saveAll(List.of(
                new UserAccount("operator", demo, "许澄", UserAccount.Role.DOMAIN_USER, "MAP-CHEM"),
                new UserAccount("planner", demo, "黎安", UserAccount.Role.DOMAIN_OPERATOR, null),
                new UserAccount("quality", demo, "顾清", UserAccount.Role.QUALITY, null),
                new UserAccount("admin", encoder.encode("ZhuaTech@2026"), "系统管理员", UserAccount.Role.ADMIN, null)
            ));
        };
    }
}
