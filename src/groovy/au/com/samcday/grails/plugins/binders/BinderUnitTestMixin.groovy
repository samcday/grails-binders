package au.com.samcday.grails.plugins.binders

import grails.test.mixin.support.GrailsUnitTestMixin
import org.junit.BeforeClass
import org.junit.Before

class BinderUnitTestMixin extends GrailsUnitTestMixin {
    @BeforeClass
    public static void configure() {
        if(applicationContext == null) {
            initGrailsApplication()
        }
    }

    def <T> T mockBinder(Class<T> binderClass) {
        grailsApplication.registerArtefactHandler(new BinderArtefactHandler())

        def binderArtefact = grailsApplication.addArtefact(BinderArtefactHandler.TYPE, binderClass)

        defineBeans {
            "${binderArtefact.propertyName}"(binderClass) { bean ->
                bean.autowire = true
            }
        }

        applicationContext.getBean(binderArtefact.propertyName, binderClass)
    }
}
