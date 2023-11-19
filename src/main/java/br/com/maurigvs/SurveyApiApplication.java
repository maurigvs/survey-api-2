package br.com.maurigvs;

import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "Survey API",
                description = "A simple Survey application",
                version = "v0.0.1",
                license = @License(
                        name = "Apache 2.0",
                        url = "http://quakus.io"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "More projects from Developer",
                url = "https://github.com/maurigvs"
        ))
public class SurveyApiApplication extends Application {

}
