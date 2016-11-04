package open.trivia.services;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/*
http://stackoverflow.com/questions/18992880/exclude-component-from-componentscan
Exclude @Component from @ComponentScan.
Use new conditional annotations. Since plain Spring 4 you can use @Conditional annotation.
*/

public class ExcludeCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}