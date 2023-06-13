package zemployee
import grails.scaffolding.*
import grails.converters.JSON
class TeamLeadController {
    static scaffold = TeamLead
    TeamLeadService teamLeadService

    def ListAll(){
        def results =TeamLead.list()
        
        def teamLeadList = results.collect { teamlead ->
            [
                teamlead : teamlead.firstName,
                team: teamlead.team.name,
                designation: teamlead.designation,
                    // Include other team attributes here
        
                employee: [
                    teamlead.employee
                ]
            ]
         }

        render teamLeadList as JSON
    }
    }


