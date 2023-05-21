package org.hygge.generator.controller.security;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.hygge.generator.domain.response.Response;
import org.hygge.generator.security.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "密码模块"
)
@RestController
@RequestMapping(
        path = "/password"
)
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @Operation(
            summary = "随机密码生成"
    )
    @Parameters(
            @Parameter(name = "length", in = ParameterIn.QUERY, description = "密码长度", required = true)
    )
    @GetMapping(path = "/random/build")
    public Response<String> randomBuild(@Valid @Min(value = 8) @RequestParam(name = "length") Integer length) {
        return Response.success(passwordService.generateRandomPassword(length));
    }
}
