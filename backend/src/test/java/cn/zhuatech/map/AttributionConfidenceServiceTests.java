/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.map;
import cn.zhuatech.map.service.AttributionConfidenceService;import org.junit.jupiter.api.Test;import java.math.*;import static org.junit.jupiter.api.Assertions.*;
class AttributionConfidenceServiceTests {private final AttributionConfidenceService service=new AttributionConfidenceService();
 @Test void trustsWellInstrumentedAttribution(){var r=service.evaluate(new AttributionConfidenceService.Request(1000,950,b("1000000"),b("900000"),b("200000"),95,80));assertEquals("RELIABLE",r.status());assertEquals(4.5,r.attributedRoas());}
 @Test void flagsSparseEvidence(){var r=service.evaluate(new AttributionConfidenceService.Request(1000,400,b("1000000"),b("300000"),b("200000"),50,20));assertEquals("LOW_CONFIDENCE",r.status());}private BigDecimal b(String v){return new BigDecimal(v);}}
