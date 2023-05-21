package org.hygge.generator.controller.code;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hygge.generator.code.CodeService;
import org.hygge.generator.domain.response.Response;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "代码模块"
)
@RestController
@RequestMapping(
        path = "/code"
)
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @Operation(
            summary = "生成代码预览"
    )
    @Parameters(
            @Parameter(name = "templateId", in = ParameterIn.QUERY, description = "模板ID", required = true)
    )
    @GetMapping(path = "/preview")
    public Response<String> preview(@Valid @NotNull @RequestParam(name = "templateId") Long templateId){
        return Response.success(codeService.preview(templateId));
    }
}
