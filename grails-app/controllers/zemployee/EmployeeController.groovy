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
                user : [
                    employee,
                ],
                subordinate: [
                    employee.hasProperty('employee') ? employee.employee : []  // Show empty array if employee.employee is null

                ],
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
       def ListAll(){
        def results =Employee.list()
        
        def employeeList = results.collect { employee ->
            [
                id: employee.id,
                firstName:employee.firstName,
                lastName:employee.lastName,
                gender: employee.gender,
                designation:employee.designation,
                email:employee.email,
                phoneNumber: employee.phoneNumber,
                address: employee.address,
                isTeamlead: employee.isTeamlead,
                nationality: employee.nationality,
                subordinate: employee.hasProperty('employee') ? employee.employee : [],
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
