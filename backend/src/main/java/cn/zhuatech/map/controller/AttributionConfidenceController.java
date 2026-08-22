/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.map.controller;
import cn.zhuatech.map.common.ApiResponse;import cn.zhuatech.map.service.AttributionConfidenceService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/map/insights/attribution-confidence") public class AttributionConfidenceController {private final AttributionConfidenceService service;public AttributionConfidenceController(AttributionConfidenceService service){this.service=service;}@PostMapping ApiResponse<AttributionConfidenceService.Result> evaluate(@Valid @RequestBody AttributionConfidenceService.Request request){return ApiResponse.ok(service.evaluate(request));}}
