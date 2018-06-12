package person.cznno.zero.base.config;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.util.ClassUtils;

import java.beans.Introspector;

@Configuration
public class QualifiedBeanNameGenerator extends AnnotationBeanNameGenerator {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        String className;
        if (definition instanceof ScannedGenericBeanDefinition) {
            final ScannedGenericBeanDefinition scanDefinition = (ScannedGenericBeanDefinition) definition;
            className = scanDefinition.getMetadata().getClassName();
        } else {
            className = ClassUtils.getShortName(definition.getBeanClassName());
        }
        return Introspector.decapitalize(className);
    }
}