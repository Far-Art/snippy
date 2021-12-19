package com.farart.snippy.tests;

import com.farart.snippy.beans.IconsPath;
import com.farart.snippy.entities.ComplementaryField;
import com.farart.snippy.entities.Snippet;
import com.farart.snippy.entities.User;
import com.farart.snippy.repositories.UsersRepository;
import com.farart.snippy.security.RegisterManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DummyData implements CommandLineRunner {

    private final UsersRepository usersRepository;

    private final RegisterManager registerManager;

    @Override
    public void run(String... args) {
        initDatabase();
    }

    private void initDatabase() {
        /* init user */
        User user = new User();
        user.setEmail("aaa@aaa.com");
        user.setPassword("1234");
        user.setFirstName("artur");
        user.setLastName("farmanov");
        user.setUserId(registerManager.createUniqueID());

        /* init snippets */
        List<Snippet> snippetList = new ArrayList<>();

        /* snippet 1 */
        Snippet snippet1 = new Snippet();
        snippet1.setUser(user);
        snippet1.setIcon(IconsPath.DOCKER);
        snippet1.setCommandLine("docker containers remove {container-id}");
        snippet1.setAppName("Docker");
        snippet1.setQuickDescription("remove docker container");
        snippet1.addComplementaryField("documentation link" , getField("https://docs.docker.com/engine/reference/commandline/rm/"));
        snippet1.addComplementaryField("os", getField("windows"));
        snippetList.add(snippet1);

        /* snippet 2 */
        Snippet snippet2 = new Snippet();
        snippet2.setUser(user);
        snippet2.setIcon(IconsPath.APPLE);
        snippet2.setCommandLine("docker run -d {container-id}");
        snippet2.setAppName("Docker");
        snippet2.setQuickDescription("run in detached mode (in background)");
        snippet2.addComplementaryField("os", getField("Mac OS"));
        snippetList.add(snippet2);

        /* snippet 3 */
        Snippet snippet3 = new Snippet();
        snippet3.setUser(user);
        snippet3.setIcon(IconsPath.WINDOWS);
        snippet3.setCommandLine("cd {directory}/{directory}");
        snippet3.setAppName("cmd");
        snippet3.setQuickDescription("change directory");
        snippet3.addComplementaryField("example 1" , getField("cd windows/system32"));
        snippet3.addComplementaryField("os", getField("Windows"));
        snippetList.add(snippet3);

        /* snippet 3 */
        Snippet snippet4 = new Snippet();
        snippet4.setUser(user);
        snippet4.setIcon(IconsPath.GENERIC);
        snippet4.setCommandLine("dummy func {func name}");
        snippet4.setAppName("Chrome OS function");
        snippet4.setQuickDescription("function");
        snippet4.addComplementaryField("Big(O)" , getField("O(n)"));
        snippet4.addComplementaryField("os", getField("Chrome OS"));
        snippetList.add(snippet4);

        /* snippet 3 */
        Snippet snippet5 = new Snippet();
        snippet5.setUser(user);
        snippet5.setIcon(IconsPath.EXCEL);
        snippet5.setCommandLine("{cell1} + {cell2}");
        snippet5.setAppName("Excel");
        snippet5.setQuickDescription("sum two cells");
        snippet5.addComplementaryField("example 1" , getField("a + b"));
        snippetList.add(snippet5);

        user.setSnippets(snippetList);
        usersRepository.save(user);
    }


    private ComplementaryField getField(String content) {
        ComplementaryField field = new ComplementaryField();
        field.setContent(content);
        return field;
    }
}
