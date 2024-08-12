package com.rehan.exampleplugin;

import java.util.Arrays;
import java.util.List;

import com.redhat.devtools.lsp4ij.server.ProcessStreamConnectionProvider;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class MyLanguageServer extends ProcessStreamConnectionProvider {
    public MyLanguageServer(@NotNull Project project) {
        List<String> commands = Arrays.asList("kcl-language-server");
        System.out.println("its working");
        super.setCommands(commands);
    }
}
