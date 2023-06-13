package zemployee
// import grails.rest.*
// @Resource(uri='/subordinate')
class Team {
    String name
    static belongsTo = [department: Department]
    static hasMany = [teamLead : TeamLead]

    static constraints = {
        name nullable: false
    }
}
