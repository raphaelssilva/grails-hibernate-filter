grails.project.work.dir = 'target'
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()
    }

    dependencies {}

    plugins {
        build(":release:3.1.1", ":rest-client-builder:2.1.1") {
            export = false
        }
        compile(":hibernate4:4.3.10")

    }
}
