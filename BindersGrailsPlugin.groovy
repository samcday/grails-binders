import au.com.samcday.grails.plugins.binders.BinderArtefactHandler
import au.com.samcday.grails.plugins.binders.CustomPropertyEditorRegistrar

class BindersGrailsPlugin {
    // the plugin version
    def version = "0.3"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [:]
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Binders Plugin" // Headline display name of the plugin
    def author = "Sam Day"
    def authorEmail = "sam.c.day@gmail.com"
    def description = '''\
Custom data binding made easy.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/binders"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
//    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
//    def organization = [ name: "My Company", url: "http://www.my-company.com/" ]

    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]

    // Location of the plugin's issue tracker.
//    def issueManagement = [ system: "JIRA", url: "http://jira.grails.org/browse/GPMYPLUGIN" ]

    // Online location of the plugin's browseable source code.
//    def scm = [ url: "http://svn.grails-plugins.codehaus.org/browse/grails-plugins/" ]

    def watchedResources = [
            "file:./grails-app/utils/*Binder.groovy"
    ]

    def artefacts = [BinderArtefactHandler]

    def doWithWebDescriptor = { xml ->
        // TODO Implement additions to web.xml (optional), this event occurs before
    }

    def doWithSpring = {
        customPropertyEditorRegistrar(CustomPropertyEditorRegistrar) {
            grailsApplication = ref("grailsApplication")
        }
    }

    def doWithDynamicMethods = { ctx ->
        // TODO Implement registering dynamic methods to classes (optional)
    }

    def doWithApplicationContext = { applicationContext ->
        // TODO Implement post initialization spring config (optional)
    }

    def onChange = { event ->
        if (application.isArtefactOfType(BinderArtefactHandler.TYPE, event.source)) {
            application.addArtefact(BinderArtefactHandler.TYPE, event.source)
        }
    }

    def onConfigChange = { event ->
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    def onShutdown = { event ->
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
