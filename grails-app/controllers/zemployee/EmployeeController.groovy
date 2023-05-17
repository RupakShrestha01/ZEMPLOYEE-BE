package zemployee
import grails.scaffolding.*
import grails.converters.*
class EmployeeController {
    static scaffold = Employee
    EmployeeService employeeService

    def search() {
        def query = params.query // Passing the search query is as a request parameter
        def results = employeeService.searchEmployee(query)
        render results as JSON // Render the results in a view
    }

}
