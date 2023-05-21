package org.hygge.generator.controller.template;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hygge.generator.domain.request.TemplateAddRequest;
import org.hygge.generator.domain.request.TemplateListRequest;
import org.hygge.generator.domain.request.TemplateModifyRequest;
import org.hygge.generator.domain.response.Response;
import org.hygge.generator.domain.vo.PageVo;
import org.hygge.generator.domain.vo.TemplateGetVo;
import org.hygge.generator.domain.vo.TemplateListVo;
import org.hygge.generator.template.TemplateService;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "模板模块"
)
@RestController
@RequestMapping(
        path = "/template"
)
public class TemplateController {

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService) {
        this.templateService = templateService;
    }

    @Operation(
            summary = "模板详情"
    )
    @Parameters(
            @Parameter(name = "templateId", in = ParameterIn.PATH, description = "模板ID", required = true)
    )
    @GetMapping(path = "/get/{templateId}")
    public Response<TemplateGetVo> templateGet(@Valid @NotNull @PathVariable(name = "templateId") Long templateId) {
        return Response.success(templateService.templateGet(templateId));
    }

    @Operation(
            summary = "模板列表"
    )
    @PostMapping(path = "/list")
    public Response<PageVo<TemplateListVo>> templateList(@Valid @RequestBody TemplateListRequest request) {
        return Response.success(templateService.templateList(request));
    }

    @Operation(
            summary = "新增公共模板"
    )
    @PostMapping(path = "/add/public")
    public Response<Boolean> templateAddPublic(@Valid @RequestBody TemplateAddRequest request) {
        return Response.success(templateService.templateAddPublic(request));
    }

    @Operation(
            summary = "新增私人模板"
    )
    @PostMapping(path = "/add/private")
    public Response<Boolean> templateAddPrivate(@Valid @RequestBody TemplateAddRequest request) {
        return Response.success(templateService.templateAddPrivate(request));
    }

    @Operation(
            summary = "更新模板"
    )
    @PutMapping(path = "/modify")
    public Response<Boolean> templateModify(@Valid @RequestBody TemplateModifyRequest request) {
        return Response.success(templateService.templateModify(request));
    }
}
