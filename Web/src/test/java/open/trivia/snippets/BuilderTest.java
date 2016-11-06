package open.trivia.snippets;

import open.trivia.QA;
import org.junit.Test;

public class BuilderTest {

    @Test
    public void test() {

        // Example instantiating a builder
        QA.QABuilder builder = QA.builder();
        builder.question("Three of these animals hibernate. Which one does not?");
        builder.answer("Sloth");
        builder.category("animals");
        builder.choices(new String[]{"Mouse", "Sloth", "Frog", "Snake"});

        QA qa = builder.build();
        System.out.println(qa);
    }

}
