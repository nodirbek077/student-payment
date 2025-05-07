package uz.asianuniversity.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Student Payment System API",
                description = "Information about management of student payment system",
                version = "1.0"
        ),
        security = {
                @SecurityRequirement(
                        name = "basicAuth"
                )
        }
)
@SecurityScheme(
        name = "basicAuth",
        description = "JWT auth description",
        scheme = "basic",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenAPIConfig {
}
