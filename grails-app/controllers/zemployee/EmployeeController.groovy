package zemployee
import grails.scaffolding.*

class EmployeeController {
    static scaffold = Employee
    EmployeeService employeeService

    def search() {
        def query = params.query // Passing the search query is as a request parameter
        def results = employeeService.searchEmployee(query)
        [employee: results, query: query] // Render the results in a view
    }

}
