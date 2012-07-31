class BootStrap {

    def init = { servletContext ->
		RegularPerson john = new RegularPerson(
			name: 'John Smith',
			birthday: new Birthday(new Date())
		)
		john.save(flush: true)
		println "john errors: ${john.errors.allErrors}"
		
    	BornAgainPerson jane = new BornAgainPerson(
    		name: 'Jane Smith',
    		birthdays: [
    			new Birthday(new Date())
    		]
    	)
    	jane.save(flush: true)
		println "jane errors: ${jane.errors.allErrors}"
    }
    def destroy = {
    }
}
