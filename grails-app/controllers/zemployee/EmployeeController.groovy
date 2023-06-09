package zemployee
import grails.scaffolding.*
import grails.converters.*
import grails.converters.JSON
class EmployeeController {
    static scaffold = Employee
    EmployeeService employeeService

    def search() {
        def query = params.employee // Passing the search query as a request parameter
        def results = employeeService.searchEmployee(query)
        
        def employeeList = results.collect { employee ->
            [
                id: employee.id,
                name: employee.firstName,
                team: [
                  employee.team
                    // Include other team attributes here
                ],
                teamLead : [
                employee.teamLead
                ]
            ]
        }

        render employeeList as JSON
    }

}
