package zemployee

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TeamLeadController {

    TeamLeadService teamLeadService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond teamLeadService.list(params), model:[teamLeadCount: teamLeadService.count()]
    }

    def show(Long id) {
        respond teamLeadService.get(id)
    }

    def create() {
        respond new TeamLead(params)
    }

    def save(TeamLead teamLead) {
        if (teamLead == null) {
            notFound()
            return
        }

        try {
            teamLeadService.save(teamLead)
        } catch (ValidationException e) {
            respond teamLead.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'teamLead.label', default: 'TeamLead'), teamLead.id])
                redirect teamLead
            }
            '*' { respond teamLead, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond teamLeadService.get(id)
    }

    def update(TeamLead teamLead) {
        if (teamLead == null) {
            notFound()
            return
        }

        try {
            teamLeadService.save(teamLead)
        } catch (ValidationException e) {
            respond teamLead.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'teamLead.label', default: 'TeamLead'), teamLead.id])
                redirect teamLead
            }
            '*'{ respond teamLead, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        teamLeadService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'teamLead.label', default: 'TeamLead'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teamLead.label', default: 'TeamLead'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
