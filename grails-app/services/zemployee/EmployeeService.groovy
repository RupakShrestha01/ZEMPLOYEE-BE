package zemployee
import grails.gorm.transactions.Transactional

@Transactional(readOnly = true)
class EmployeeService {

    def searchEmployee(String query) {
        def normalizedQuery =  query?.trim()?.toLowerCase()
        if (normalizedQuery) {
        def results = Employee.createCriteria().list {
            or {
                ilike("firstName", "%${normalizedQuery}%") // Search by firstName (case-insensitive)
                ilike("designation", "%${normalizedQuery}%") // Search by designation (case-insensitive)
            }
        }

            return results
        }else{
             return [] // Return an empty list if the query is null
            }
    }
}