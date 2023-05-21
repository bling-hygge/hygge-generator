package org.hygge.generator.controller.code;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Java模块"
)
@RestController
@RequestMapping(
        path = "/java"
)
public class JavaController {
}
