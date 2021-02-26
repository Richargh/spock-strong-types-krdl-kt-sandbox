package de.richargh.sandbox.spock.strongtypes

import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo

import static de.richargh.sandbox.spock.strongtypes.PersonBuilderKt.person

/**
 * Extension code copied form <a href="https://github.com/spockframework/spock/issues/1279">this issue</a>.
 * The original Author is <a href="https://github.com/Vampire">Björn Kautler</a>.
 */
class MakePersonExtension implements IAnnotationDrivenExtension<MakePerson> {
    @Override
    void visitFeatureAnnotation(MakePerson annotation, FeatureInfo feature) {
        feature.featureMethod.addInterceptor(new IMethodInterceptor() {
            @Override
            void intercept(IMethodInvocation invocation) throws Throwable {
                invocation.arguments[2] = person {
                    it.withName(invocation.arguments[0] as String)
                    it.withAge(invocation.arguments[1] as Integer)
                }
                invocation.proceed()
            }
        })
    }
}
