package zemployee
// import grails.rest.*
// @Resource(uri='/subordinate')
class Team {
    String teamName
    static belongsTo = [department: Department]
    static hasMany = [teamLead : TeamLead, employees: Employee]

    static constraints = {
        teamName nullable: false
    }
}
