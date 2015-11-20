import org.grails.plugin.hibernate.filter.DefaultHibernateFiltersHolder

class HibernateFilterFilters {

	def sessionFactory
	def grailsApplication

	def filters = {
		enableHibernateFilters(controller:'*', action:'*') {
			before = {
				def session = sessionFactory.currentSession
				for (String name in DefaultHibernateFiltersHolder.defaultFilters) {
					def filter = session.enableFilter name

					def postEnableFilter = grailsApplication.config.filter.postEnableFilter

					if(postEnableFilter){
						postEnableFilter(filter)
					}
				}
			}
		}
	}
}
