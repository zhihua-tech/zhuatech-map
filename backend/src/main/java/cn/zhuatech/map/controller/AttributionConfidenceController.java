/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.map.controller;
import cn.zhuatech.map.common.ApiResponse;import cn.zhuatech.map.service.AttributionConfidenceService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/map/insights/attribution-confidence") public class AttributionConfidenceController {private final AttributionConfidenceService service;/**
                                                                                                                                                                              * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                              */
public AttributionConfidenceController(AttributionConfidenceService service){this.service=service;}/**
                                                                                                                                                                                                                                                                                 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                 */
@PostMapping ApiResponse<AttributionConfidenceService.Result> evaluate(@Valid @RequestBody AttributionConfidenceService.Request request){return ApiResponse.ok(service.evaluate(request));}}
